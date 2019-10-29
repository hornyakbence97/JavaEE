
package hu.oenik7.web.bl;


public class Ability {

    byte force, brain, skill;

    public byte getForce() {
        return force;
    }

    public void setForce(byte force) {
        this.force = force;
    }

    public byte getBrain() {
        return brain;
    }

    public void setBrain(byte brain) {
        this.brain = brain;
    }

    public byte getSkill() {
        return skill;
    }

    public void setSkill(byte skill) {
        this.skill = skill;
    }

    public Ability(byte force, byte brain, byte skill) {
        this.force = force;
        this.brain = brain;
        this.skill = skill;
    }

    public Ability() {
    }
}
