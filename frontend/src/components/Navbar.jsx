import { useState } from "react";

export default function Navbar({ onTabChange }) {
  const [activeTab, setActiveTab] = useState("character");

  const handleClick = (tab) => {
    if (tab === activeTab) return;
    setActiveTab(tab);
    onTabChange(tab);
  };

  const tabClass = (tab) =>
    tab === activeTab
      ? "-mb-px py-3 px-4 inline-flex items-center gap-2 bg-violet-600 text-sm font-medium text-center border border-violet-600 border-b-transparent text-gray-200 rounded-t-lg focus:outline-hidden "
      : "-mb-px py-3 px-4 inline-flex items-center gap-2 bg-violet-900 text-sm font-medium text-center border border-violet-900 text-gray-300 rounded-t-lg hover:text-gray-700 focus:outline-hidden focus:text-gray-700 dark:bg-neutral-700 dark:border-neutral-700 dark:text-neutral-400 dark:hover:text-neutral-300 dark:focus:text-neutral-300";

  const disabledClass =
    "bg-stone-100 inline-block py-2 px-4 text-gray-400 font-semibold cursor-not-allowed";

  return (
    <div className="sticky top-0 z-50 backdrop-blur">
      <nav className="flex gap-x-2">
        <a href="#" aria-current="page" className={tabClass("character")} onClick={() => handleClick("character")}>
            Character
        </a>
        <a href="#" aria-current="page" className={tabClass("skills")} onClick={() => handleClick("skills")}>
            Skills
        </a>
        <a href="#" aria-current="page" className={tabClass("definitions")}  onClick={() => handleClick("definitions")}>
            Skill Definitions
        </a>
        <a href="#" aria-current="page" className={tabClass("fighting")}  onClick={() => handleClick("fighting")}>
            Fighting
        </a>
      </nav>
    </div>
  );

}
