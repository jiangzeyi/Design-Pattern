package cn.maxiaot.build;

    public class FruitsPazzBuilder extends PazzBuilder {
        @Override
        public PazzBuilder choiceTaste() {
            super.pazz.setTaste("甜");
            return this;
        }

        @Override
        public PazzBuilder choiceTopping() {
            super.pazz.setTopping("水果");
            return this;
        }
    }
