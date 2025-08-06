import { useFetch } from "../hooks/useFetch";
import { fetchPlayerSkills, fetchSkillDifficulties } from "../http";
import { useMemo } from "react";
import Skill from "./Skill";

export default function Skills() {

    const fetchArgs = useMemo(() => ({ id: 1 }), []);

    const {
        isLoading: loading,
        error,
        fetchedData: playerSkills,
    } = useFetch(fetchPlayerSkills, fetchArgs, []);

    const {
        fetchedData: difficulties,
    } = useFetch(fetchSkillDifficulties, null, []);

    function getThresholdsFor(difficultyName) {
        const difficulty = difficulties.find(d => d.name === difficultyName);
        return difficulty ? difficulty.thresholds : [];
    }



    if (loading) return <p>Loading player skills...</p>;
    if (error) return <p className="text-red-500">{error.message}</p>;

    console.log(playerSkills);

    return (<>
        <h2 className="text-purple-200 text-3xl mb-4 font-bold">Character skills</h2>
        <ul className="pl-6">
            {playerSkills.map((skill) => (
                <Skill
                    key={skill.id}
                    skill={skill}
                    threshold={getThresholdsFor(skill.difficulty)}
                    kp={skill.kp}
                />
            ))}
        </ul>
    </>

    )
}