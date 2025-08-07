// usePlayerAutosave.js – a tiny save manager hook
import { useCallback, useRef } from "react";
import { deepEqual } from "../store/playerSlice";

export function usePlayerAutosave({ player, lastSavedPlayer, setLastSavedPlayer, autosave }) {
  const savingRef = useRef(false);
  const inFlightAbort = useRef(null);

  const saveIfDirty = useCallback(async () => {
    if (!autosave) return;
    if (savingRef.current) return;
    if (deepEqual(player, lastSavedPlayer)) return;

    // cancel older in-flight save if needed
    inFlightAbort.current?.abort();
    const ctrl = new AbortController();
    inFlightAbort.current = ctrl;

    try {
      savingRef.current = true;
      const resp = await fetch(`http://localhost:8080/players/${player.id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(player),
        signal: ctrl.signal,
      });
      if (!resp.ok) throw new Error("Save failed");
      if (resp.ok) console.log("Saved successfully!!! YAY!!!");
      const saved = await resp.json();

      setLastSavedPlayer(saved); // snapshot success
    } catch (e) {
      // optional: toast/error banner; keep dirty
      console.error(e);
    } finally {
      savingRef.current = false;
    }
  }, [autosave, player, lastSavedPlayer, setLastSavedPlayer]);

  return { saveIfDirty };
}
