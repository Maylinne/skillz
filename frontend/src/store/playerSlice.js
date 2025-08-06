import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  id: 'player-001',
  name: 'Zaheera',
  race: 'HUMAN',
  attributes: [
    { id: 'attr-1', name: 'STRENGTH', value: 10, playerId: 'player-001' },
    { id: 'attr-2', name: 'DEXTERITY', value: 16, playerId: 'player-001' },
    { id: 'attr-3', name: 'SPEED', value: 11, playerId: 'player-001' },
    { id: 'attr-4', name: 'STAMINA', value: 12, playerId: 'player-001' },
    { id: 'attr-5', name: 'HEALTH', value: 10, playerId: 'player-001' },
    { id: 'attr-6', name: 'CHARISMA', value: 13, playerId: 'player-001' },
    { id: 'attr-7', name: 'INTELLIGENCE', value: 17, playerId: 'player-001' },
    { id: 'attr-8', name: 'WILLPOWER', value: 16, playerId: 'player-001' },
    { id: 'attr-9', name: 'ASTRAL', value: 16, playerId: 'player-001' },
    { id: 'attr-10', name: 'PERCEPTION', value: 14, playerId: 'player-001' }
  ],
  skills: [
    {
      skillDef: {
        id: 8,
        name: 'Ostromgép',
        difficulty: 'NORMAL',
        attribute: 'INTELLIGENCE'
      },
      value: 1
    },
    {
      skillDef: {
        id: 11,
        name: 'Taktika',
        difficulty: 'NORMAL',
        attribute: 'INTELLIGENCE'
      },
      value: 2
    },
    {
      skillDef: {
        id: 13,
        name: 'Harcművészet',
        difficulty: 'NORMAL',
        attribute: 'SPEED'
      },
      value: 3
    },
    {
      skillDef: {
        id: 1,
        name: 'Fájdalomtűrés',
        difficulty: 'HARD',
        attribute: 'STAMINA'
      },
      value: 2
    },
    {
      skillDef: {
        id: 7,
        name: 'Földharc',
        difficulty: 'NORMAL',
        attribute: 'STRENGTH'
      },
      value: 2
    }
  ]
};

const playerSlice = createSlice({
  name: 'player',
  initialState,
  reducers: {
    incrementAttribute(state, action) {
      const attr = state.attributes.find(a => a.name === action.payload);
      if (attr) {
        attr.value++;
      }
    },
    
    decrementAttribute(state, action) {
      const attr = state.attributes.find(a => a.name === action.payload);
      if (attr) {
        attr.value--;
      }
    }
  }
});

export const playerActions = playerSlice.actions;
export default playerSlice.reducer;
