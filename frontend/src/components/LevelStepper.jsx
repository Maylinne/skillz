export default function LevelStepper({ thresholds, currentKP }) {
  // Determine current level
  let total = 0;
  let currentLevel = thresholds.length - 1;

  for (let i = 0; i < thresholds.length; i++) {
    total += thresholds[i];
    if (currentKP < total) {
      currentLevel = i;
      break;
    }
  }

  // KP in current level
  const previousThresholds = thresholds.slice(0, currentLevel).reduce((a, b) => a + b, 0);
  const kpInLevel = currentKP - previousThresholds;
  const currentLevelMax = thresholds[currentLevel];

  return (
    <div className="flex items-center w-52 m-2">
      {thresholds.map((kp, index) => {
        const completed = index < currentLevel;
        const active = index === currentLevel;

        return (
          <div key={index} className="flex items-center">
            {/* Circle */}
            <div
              className={`w-8 h-8 flex items-center justify-center rounded-full border-2 text-sm font-bold ${
                completed
                  ? "bg-green-500 text-white border-green-500"
                  : active
                  ? "border-blue-500 text-blue-500 text-xs"
                  : "border-gray-300 text-gray-400"
              }`}
            >
              {completed ? "✓" : active ? `${kpInLevel}/${currentLevelMax}` : kp}
            </div>

            {/* Connector line */}
            {index < thresholds.length - 1 && (
              <div className="w-3 h-0.5 bg-gray-300" />
            )}
          </div>
        );
      })}
    </div>
  );
}
