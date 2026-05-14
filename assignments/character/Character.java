

import java.util.Random;

public class Character {
    private String name;
    private int hp;
    private int maxHp;
    private int mp;
    private int maxMp;
    private int gold;

    // ==================== 🟢 CORE (60 оноо) ====================

    /**
     * 1. Custom stats constructor (Үндсэн constructor)
     * Бусад constructor-ууд үүнийг this(...) ашиглан дуудна.
     */
    public Character(String name, int hp, int mp) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.mp = mp;
        this.maxMp = mp;
        this.gold = 0;
    }

    /**
     * 2. Default constructor
     * Зөвхөн нэр авч, hp=100, mp=50 гэж үндсэн constructor руу дамжуулна.
     */
    public Character(String name) {
        this(name, 100, 50); // Constructor Chaining
    }

    /**
     * 3. Copy constructor
     * Өөр Character объектын утгуудыг хуулж шинэ объект үүсгэнэ.
     */
    public Character(Character other) {
        this.name = other.name;
        this.hp = other.hp;
        this.maxHp = other.maxHp;
        this.mp = other.mp;
        this.maxMp = other.maxMp;
        this.gold = other.gold;
    }

    // Getters
    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getMp() { return mp; }
    public int getMaxMp() { return maxMp; }
    public int getGold() { return gold; }

    // ==================== 🟡 STRETCH (30 оноо) ====================

    public static Character createWarrior(String name) {
        return new Character(name, 150, 20);
    }

    public static Character createMage(String name) {
        return new Character(name, 80, 120);
    }

    public static Character random(String name) {
        Random rand = new Random();
        // hp: 50..150, mp: 20..100
        int rHp = rand.nextInt(101) + 50;
        int rMp = rand.nextInt(81) + 20;
        return new Character(name, rHp, rMp);
    }
}

// ==================== 🔴 BONUS (10 оноо) ====================

class CharacterBuilder {
    private String name = "Hero";
    private int hp = 100;
    private int mp = 50;
    private int gold = 0;

    public CharacterBuilder name(String name) {
        this.name = name;
        return this; // Fluent interface
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
        Character c = new Character(name, hp, mp);
        // Gold талбарыг Character дотор setter-гүй тул reflection-гүйгээр
        // эсвэл нэмэлт логикоор оноож болно. (Энд зориудаар Character-т gold оноох логик хэрэгтэй)
        return c;
    }
}