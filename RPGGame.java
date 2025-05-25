// [1] Abstract Class Character (TANPA 'public' dan 'sealed')
abstract class Character {
    protected String name;
    protected int level;

    public Character(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public abstract void attack();
}

// [2] Interface Skill (TANPA 'public')
interface Skill {
    void useSpecialSkill();
}

// [3] Class Warrior (TANPA 'public')
final class Warrior extends Character implements Skill {
    public Warrior(String name, int level) {
        super(name, level);
    }

    @Override
    public void attack() {
        System.out.println(name + " (Warrior) slashes with sword! ⚔️");
    }

    @Override
    public void useSpecialSkill() {
        System.out.println(name + " uses Berserker Rage! 🔥");
    }
}

// [4] Class Mage (TANPA 'public')
final class Mage extends Character implements Skill {
    public Mage(String name, int level) {
        super(name, level);
    }

    @Override
    public void attack() {
        System.out.println(name + " (Mage) casts a fireball! 🔥");
    }

    @Override
    public void useSpecialSkill() {
        System.out.println(name + " summons a Meteor Storm! ☄️");
    }
}

// [5] Class LegendaryKnight (TANPA 'public')
final class LegendaryKnight extends Character {
    public LegendaryKnight(String name, int level) {
        super(name, level);
    }

    @Override
    public void attack() {
        System.out.println(name + " (Legendary Knight) unleashes Holy Blade! ✨");
    }
}

// [6] Class Utama (INI SATU-SATUNYA YANG 'public')
public class RPGGame {
    public static void main(String[] args) {
        Character[] party = {
            new Warrior("Guts", 50),
            new Mage("Gandalf", 99),
            new LegendaryKnight("Arthur", 100)
        };

        for (Character character : party) {
            character.attack();
            
            if (character instanceof Skill) {
                ((Skill)character).useSpecialSkill();
            }
            System.out.println("---------------");
        }
    }
}