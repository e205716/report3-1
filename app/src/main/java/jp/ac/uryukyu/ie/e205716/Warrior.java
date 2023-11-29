package jp.ac.uryukyu.ie.e205716;

public class Warrior extends Hero {

    public Warrior(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }

    // attackWithWeaponSkillメソッドの追加
    public void attackWithWeaponSkill(LivingThing opponent) {
        int damage = (int) (super.getAttack() * 1.5); // 親クラスのgetAttack()メソッドを呼び出す
        opponent.wounded(damage); // ダメージを相手に与える
        System.out.printf("%sの攻撃！ウェポンスキルを発動！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
    }
}
