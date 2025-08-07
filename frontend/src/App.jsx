import { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { AnimatePresence, motion } from "framer-motion";

import "./App.css";

import Navbar from "./components/Navbar";
import Player from "./components/Player";
import Skills from "./components/Skills";
import SkillDefinitions from "./components/SkillDefinitions";
import DarkVeil from "./components/ReactBits/DarkVeil";
import { usePlayerAutosave } from "./hooks/usePlayerAutosave";

// selectors + actions from the slice
import {
  selectPlayer,
  selectLastSaved,
  selectStatus,
  setLoading,
  loadPlayer,
  setError,
  snapshotSaved,
} from "./store/playerSlice";

export default function App() {
  const [activeTab, setActiveTab] = useState("character");
  const [autosave, setAutosave] = useState(true);
  const [editMode, setEditMode] = useState(false);

  const dispatch = useDispatch();

  // ✅ use selectors that match the slice
  const player = useSelector(selectPlayer);           // null | Player
  const lastSavedPlayer = useSelector(selectLastSaved);
  const status = useSelector(selectStatus);           // 'idle' | 'loading' | ...

  // initial load
  useEffect(() => {
    (async () => {
      try {
        dispatch(setLoading());
        const resp = await fetch("http://localhost:8080/players/player/1");
        if (!resp.ok) throw new Error("Failed to fetch player");
        const data = await resp.json();
        dispatch(loadPlayer(data));
      } catch (e) {
        dispatch(setError(e.message));
      }
    })();
  }, [dispatch]);

  // autosave hook wired to slice
  const { saveIfDirty } = usePlayerAutosave({
    player,
    lastSavedPlayer,
    setLastSavedPlayer: () => dispatch(snapshotSaved()), // no payload needed
    autosave,
  });

  const onTabChange = async (tab) => {
    await saveIfDirty(); // save before switching away
    setActiveTab(tab);
  };

  const renderContent = () => {
    switch (activeTab) {
      case "character":
        return <Player key="character" editMode={editMode} />;
      case "skills":
        return <Skills key="skills" />;
      case "definitions":
        return <SkillDefinitions key="definitions" />;
      default:
        return null;
    }
  };

  // Gate content until player is loaded
  if (status === "loading" || !player) {
    return (
      <>
        <Navbar onTabChange={onTabChange} />
        <div className="p-4 min-h-[300px]">
          <p>Loading player…</p>
        </div>
      </>
    );
  }

  return (
    <>
      {/* Background, full-screen, zIndex 0 */}
      <div style={{ position: "fixed", inset: 0, zIndex: 0 }}>
        <DarkVeil />
      </div>

      {/* Content on top */}
      <div style={{ position: "relative", zIndex: 1 }}>
        <Navbar onTabChange={onTabChange} />

        <div id="header" className="flex flex-row mt-4">
          <h2 className="mx-8 my-2">{player.name}</h2>

          <label className="inline-flex items-center cursor-pointer mx-4 my-2">
            <input
              type="checkbox"
              checked={editMode}
              onChange={(e) => setEditMode(e.target.checked)}
              className="sr-only peer"
            />
            <div className="relative w-11 h-6 bg-gray-200 peer-focus:outline-none rounded-full peer dark:bg-gray-700 peer-checked:after:translate-x-full rtl:peer-checked:after:-translate-x-full peer-checked:after:border-white after:content-[''] after:absolute after:top-[2px] after:start-[2px] after:bg-white after:border-gray-300 after:border after:rounded-full after:h-5 after:w-5 after:transition-all peer-checked:bg-violet-500"></div>
            <span className="ms-3 text-sm font-medium text-violet-200"> Edit mode </span>
          </label>
        </div>

        <div className="p-4 min-h-[300px]">
          <AnimatePresence mode="wait">
            <motion.div
              key={activeTab}
              initial={{ opacity: 0 }}
              animate={{ opacity: 1 }}
              exit={{ opacity: 0 }}
              transition={{ duration: 0.3 }}
            >
              {renderContent()}
            </motion.div>
          </AnimatePresence>
        </div>
      </div>
    </>
  );
}
