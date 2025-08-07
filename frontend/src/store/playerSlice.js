import { createSlice } from '@reduxjs/toolkit';

export const deepEqual = (a, b) => JSON.stringify(a) === JSON.stringify(b);

const initialState = {
  current: null,
  lastSaved: null, 
  autosave: true,
  status: 'idle',   // 'idle' | 'loading' | 'succeeded' | 'failed'
  error: null
};

const playerSlice = createSlice({
  name: 'player',
  initialState,
  reducers: {
    incrementAttribute(state, action) { /* same as before but guard null */ 
      if (!state.current) return;
      const attr = state.current.attributes.find(a => a.name === action.payload);
      if (attr) attr.value++;
    },
    decrementAttribute(state, action) {
      if (!state.current) return;
      const attr = state.current.attributes.find(a => a.name === action.payload);
      if (attr) attr.value--;
    },
    setAutosave(state, action) { state.autosave = !!action.payload; },


    snapshotSaved(state) {
      if (!state.current) return;
      state.lastSaved = JSON.parse(JSON.stringify(state.current));
    },

    loadPlayer(state, action) {
      state.current   = action.payload;
      state.lastSaved = JSON.parse(JSON.stringify(action.payload));
      state.status = 'succeeded';
      state.error = null;
    },
    
    setLoading(state) { 
      state.status = 'loading'; state.error = null; 
    },
    setError(state, action) { 
      state.status = 'failed'; state.error = action.payload || 'Load failed'; 
    },
    replaceCurrent(state, action) {
      state.current = action.payload;
    }
  }
});


export const {
  incrementAttribute, decrementAttribute,
  setAutosave, snapshotSaved, loadPlayer, setLoading, setError, replaceCurrent
} = playerSlice.actions;

export default playerSlice.reducer;

// -------- Selectors --------
export const selectPlayer       = (s) => s.player.current;
export const selectLastSaved    = (s) => s.player.lastSaved;
export const selectAutosave     = (s) => s.player.autosave;
export const selectStatus       = (s) => s.player.status;
export const selectIsDirty      = (s) => !deepEqual(s.player.current, s.player.lastSaved);
