package jp.ac.uryukyu.ie.e205716;

public class Hero extends LivingThing {
    public Hero(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }

    @Override
    public void wounded(int damage) {
        super.wounded(damage);
        if (isDead()) {
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", getName());
        }
    }

    // attackのgetterを追加
    public int getAttack() {
        return this.attack;
    }

    @Override
    public void attack(LivingThing opponent) {
        if (!isDead()) {
            opponent.wounded(this.attack);
        }
    }
}
