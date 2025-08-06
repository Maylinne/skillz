export default function PercentSkill({ attributeValue, kp }) {

    const sum = attributeValue + kp;
    const barClass = "flex flex-col justify-center rounded-full overflow-hidden text-xs text-white text-center whitespace-nowrap transition-all duration-500";
    const lineColor = kp === 0 ? " bg-blue-600" : " bg-violet-600";

    return (
        <div className="mx-2 w-48 flex">
            {/* Progress */}
            <div
                className="flex w-full h-6 bg-gray-200 rounded-full overflow-hidden"
                role="progressbar"
                aria-valuenow={attributeValue + kp}
                aria-valuemin={5}
                aria-valuemax={100}
            >
                <div
                    className={barClass + lineColor}
                    style={{ width: `${sum}` }}
                >
                    {sum}
                </div>
            </div>
            {/* End Progress */}
            <div className="w-10 text-end">
                <span className="text-sm text-purple-200">
                    {kp}
                </span>
            </div>
        </div>
    );
}
