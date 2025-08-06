import { fetchSkillDifficulties, fetchSkillDefinitions } from "../http.js";
import Skill from "./Skill.jsx";
import { useFetch } from '../hooks/useFetch.js';

export default function SkillDefinitions() {

    const {
        fetchedData: difficulties,
    } = useFetch(fetchSkillDifficulties, null, []);

    const {
        isLoading: loading,
        error,
        fetchedData: skillDefs,
    } = useFetch(fetchSkillDefinitions, null, []);


    function getThresholdsFor(difficultyName) {
        const difficulty = difficulties.find(d => d.name === difficultyName);
        return difficulty ? difficulty.thresholds : [];
    }

    if (loading) return <p>Loading skill definitions...</p>;
    if (error) return <p className="text-red-500">{error}</p>;

    return (
        <div>
            <h2 className="text-xl font-bold mb-4 text-purple-200">Available Skill Definitions</h2>
            <ul className="pl-6">
                {skillDefs.map((skillDef) => (
                    <Skill
                        key={skillDef.id}
                        skill={skillDef}
                        threshold={getThresholdsFor(skillDef.difficulty)}
                        kp={0}
                    />
                ))}
            </ul>
        </div>
    );
}
