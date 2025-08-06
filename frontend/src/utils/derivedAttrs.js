function getAttrValue(attributes, name) {
    return attributes.find(attr => attr.name === name)?.value ?? 0;
}

export function initiative(attributes) {
    const speed = getAttrValue(attributes, 'SPEED');
    const perception = getAttrValue(attributes, 'PERCEPTION');

    return speed + perception;
}

export function attack(attributes) {
    const strength = getAttrValue(attributes, "STRENGTH");
    const dexterity = getAttrValue(attributes, "DEXTERITY");
    const speed = getAttrValue(attributes, "SPEED");

    return strength + dexterity + speed;
}

export function defense(attributes) {
    const dexterity = getAttrValue(attributes, "DEXTERITY");
    const speed = getAttrValue(attributes, "SPEED");

    return dexterity + speed + 75;
}

export function aim(attributes) {
    const dexterity = getAttrValue(attributes, "DEXTERITY");
    const perception = getAttrValue(attributes, 'PERCEPTION');

    return dexterity + perception;
}
