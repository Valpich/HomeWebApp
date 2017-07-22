package dev.valentinpichavant.beans;

import java.io.Serializable;

/**
 * Created by valentinpichavant on 7/22/17.
 */
public class UserConnectionPK implements Serializable {

    protected String userId;

    protected String providerId;

    protected String providerUserId;

    public UserConnectionPK() {
    }

    public UserConnectionPK(String userId, String providerId, String providerUserId) {
        this.userId = userId;
        this.providerId = providerId;
        this.providerUserId = providerUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserConnectionPK that = (UserConnectionPK) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (providerId != null ? !providerId.equals(that.providerId) : that.providerId != null) return false;
        return providerUserId != null ? providerUserId.equals(that.providerUserId) : that.providerUserId == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (providerId != null ? providerId.hashCode() : 0);
        result = 31 * result + (providerUserId != null ? providerUserId.hashCode() : 0);
        return result;
    }
}
