package jp.ac.uryukyu.ie.e205716;

/**
 * 敵クラス。
 */
public class Enemy {
    private String name; // 敵の名前
    private int hitPoint; // 敵のHP
    private int attack; // 敵の攻撃力
    private boolean dead; // 敵の生死状態。true=死亡。

    public Enemy(String name, int maximumHP, int attack) {
        this.name = name;
        this.hitPoint = maximumHP;
        this.attack = attack;
        this.dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", this.name, maximumHP, attack);
    }

    public void attack(Hero hero) {
        if (!this.dead && !hero.isDead()) {
            int damage = (int)(Math.random() * this.attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", this.name, hero.getName(), damage);
            hero.wounded(damage);
        }
    }

    public void wounded(int damage){
        this.hitPoint -= damage;
        if (this.hitPoint < 0) {
            this.dead = true;
            System.out.printf("モンスター%sは倒れた。\n", this.name);
        }
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
}
