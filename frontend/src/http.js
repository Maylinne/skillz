export async function fetchSkillDefinitions() {
  const response = await fetch("http://localhost:8080/api/skills/definitions");

  if (!response.ok) {
    throw new Error("Failed to fetch skill definitions");
  }

  const data = await response.json();
  return data; // adjust if backend wraps in `{ definitions: [...] }`
}

export async function fetchSkillDifficulties() {
  const response = await fetch("http://localhost:8080/api/skills/difficulties");

  if (!response.ok) {
    throw new Error("Failed to fetch skill difficulties");
  }

  const data = await response.json();
  return data; 
}

export async function fetchPlayerSkills({ id }) {
  const url = "http://localhost:8080/api/skills/playerSkills/" + id;
  // console.log("fetchPlayerSkills: url = " + url);

  const response = await fetch(url);

  if (!response.ok) {
    throw new Error("Failed to fetch player skills.");
  }

  const data = await response.json(); 
  console.log("Fetched from backend:", data);
  return data;
}
