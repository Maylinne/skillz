import { useState } from "react";
import './App.css';
import Navbar from "./components/Navbar";
import Player from "./components/Player";
import Skills from "./components/Skills";
import SkillDefinitions from "./components/SkillDefinitions";
import { Provider } from "react-redux";
import store from "./store/index"
import { AnimatePresence, motion } from "framer-motion";
import DarkVeil from "./components/ReactBits/DarkVeil";

export default function App() {
  const [activeTab, setActiveTab] = useState("character");

  const renderContent = () => {
    switch (activeTab) {
      case "character":
        return <Player key="character" />;
      case "skills":
        return <Skills key="skills" />;
      case "definitions":
        return <SkillDefinitions key="definitions" />;
      default:
        return null;
    }
  };

  return (
    <Provider store={store}>
      {/* Background, full-screen, zIndex 0 */}
      <div style={{ position: 'fixed', inset: 0, zIndex: 0 }}>
        <DarkVeil />
      </div>
      {/* Content on top */}
      <div style={{ position: 'relative', zIndex: 1 }}>
        <Navbar 
        onTabChange={setActiveTab} />

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
    </ Provider>
  );
}
