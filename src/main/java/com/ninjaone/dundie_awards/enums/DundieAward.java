package com.ninjaone.dundie_awards.enums;

public enum DundieAward {
        BEST_DAD_AWARD("Best Dad Award"),
        BEST_MOM_AWARD("Best Mom Award"),
        HOTTEST_IN_THE_OFFICE_AWARD("Hottest in the Office Award"),
        DIABETES_AWARD("Diabetes Award"),
        PROMISING_ASSISTANT_MANAGER_AWARD("Promising Assistant Manager Award"),
        CUTEST_REDHEAD_IN_THE_OFFICE_AWARD("Cutest Redhead in the Office Award"),
        BEST_DUNDIES_HOST_AWARD("Best Dundies Host Award"),
        EXTREME_REPULSIVENESS_AWARD("Extreme Repulsiveness Award"),
        REDEFINING_BEAUTY_AWARD("Redefining Beauty Award"),
        MOVING_ON_UP_AWARD("Moving On Up Award"),
        WORST_SALESMAN_OF_THE_YEAR("Worst Salesman of the Year");

        private final String displayName;

        DundieAward(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }

}
