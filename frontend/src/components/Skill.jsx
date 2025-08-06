import LevelStepper from "./LevelStepper";
import PercentSkill from "./PercentSkill";

export default function Skill({ skill, threshold, kp }) {

    const element = skill.difficulty !== "PERCENT" ? (

        <li key={skill.id} className="flex mb-1">
            <div className="w-50 text-purple-200">
                <strong>{skill.name} </strong>
                <br />
                {skill.attribute}
            </div>
            <LevelStepper thresholds={threshold} currentKP={kp}/>
        </li>

    ) : (

        <li key={skill.id} className="flex items-center mb-1">
            <div className="w-50 text-purple-200">
                <strong>{skill.name}</strong>
                <br />
                {skill.attribute}
            </div>
            <PercentSkill attributeValue={skill.attributeValue} kp={kp} />
        </li>

    );

    return element;
}
