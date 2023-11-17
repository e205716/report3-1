package jp.ac.uryukyu.ie.e205716;

/**
 * ヒーロークラス。
 *  String name; // ヒーローの名前
 *  int hitPoint; // ヒーローのHP
 *  int attack; // ヒーローの攻撃力
 *  boolean dead; // ヒーローの生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Hero {
    private String name; // ヒーローの名前
    private int hitPoint; // ヒーローのHP
    private int attack; // ヒーローの攻撃力
    private boolean dead; // ヒーローの生死状態。true=死亡。

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name ヒーロー名
     * @param maximumHP ヒーローのHP
     * @param attack ヒーローの攻撃力
     */
    public Hero(String name, int maximumHP, int attack) {
        this.name = name;
        this.hitPoint = maximumHP;
        this.attack = attack;
        this.dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", this.name, maximumHP, attack);
    }

    /**
     * Enemyへ攻撃するメソッド。死亡していなければ攻撃可能。
     * attackに応じて乱数でダメージを算出し、e.wounded(damage)によりダメージ処理を実行。
     * @param e 攻撃対象
     */
    public void attack(Enemy e){
        if (!this.isDead()) {
            int damage = (int)(Math.random() * this.attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", this.name, e.getName(), damage);
            e.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        this.hitPoint -= damage;
        if (this.hitPoint < 0) {
            this.dead = true;
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", this.name);
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
