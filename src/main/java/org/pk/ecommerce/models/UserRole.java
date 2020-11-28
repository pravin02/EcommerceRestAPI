package org.pk.ecommerce.models;

/**
 * @author Pravin P Patil
 * <p>
 * UserRole emun for define roles in system.
 * Total 3 roles in system
 * 1) ADMIN
 * 2) CUSTOMER
 * 3) DELIVERY_BOY
 */
public enum UserRole {

    ADMIN, CUSTOMER, DELIVERY_BOY;

    /**
     * @param userRole will take as an string
     * @return input param will map with enum if found otherwise will return null
     */
    public static UserRole getUserRole(String userRole) {
        if (userRole == null) {
            return null;
        }
        for (UserRole ur : UserRole.values()) {
            if (userRole.equals(ur.name())) {
                return ur;
            }
        }
        return null;
    }

}
