
import java.util.Random;

public class Character {
    private String name;
    private int hp;
    private int maxHp;
    private int mp;
    private int maxMp;
    private int gold;

    // Үндсэн constructor-т gold-ыг нэмж өгснөөр Builder утгаа оноож чадна
    public Character(String name, int hp, int mp, int gold) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.mp = mp;
        this.maxMp = mp;
        this.gold = gold;
    }

    // Бусад constructor-ууд одоо 4 параметртэй constructor-ыг дуудна
    public Character(String name, int hp, int mp) {
        this(name, hp, mp, 0);
    }

    public Character(String name) {
        this(name, 100, 50, 0);
    }

    public Character(Character other) {
        this(other.name, other.hp, other.mp, other.gold);
        this.maxHp = other.maxHp;
        this.maxMp = other.maxMp;
    }

    // Getters
    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getMp() { return mp; }
    public int getMaxMp() { return maxMp; }
    public int getGold() { return gold; }

    // Static Factory Methods
    public static Character createWarrior(String name) {
        return new Character(name, 150, 20, 0);
    }

    public static Character createMage(String name) {
        return new Character(name, 80, 120, 0);
    }

    public static Character random(String name) {
        Random rand = new Random();
        int rHp = rand.nextInt(101) + 50;
        int rMp = rand.nextInt(81) + 20;
        return new Character(name, rHp, rMp, 0);
    }
}

// ==================== 🔴 BONUS (Зассан Builder) ====================

class CharacterBuilder {
    private String name = "Hero";
    private int hp = 100;
    private int mp = 50;
    private int gold = 0;

    public CharacterBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CharacterBuilder hp(int hp) {
        this.hp = hp;
        return this;
    }

    public CharacterBuilder mp(int mp) {
        this.mp = mp;
        return this;
    }

    public CharacterBuilder gold(int gold) {
        this.gold = gold;
        return this;
    }

    public Character build() {
        // Одоо gold утгыг constructor руу дамжуулж байна
        return new Character(name, hp, mp, gold);
    }
}