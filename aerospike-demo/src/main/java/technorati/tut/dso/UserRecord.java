package technorati.tut.dso;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserRecord implements Serializable {

    @Id
    String uid;

    long createTime;

    Long CAS;

    Integer ttlSec;

    Map<String, String> thirdPartyIds = new HashMap<String, String>();

    String envelope;

    Long createdTS;

    Long updatedTS;

    @Transient
    private boolean hasChanges;

    UserRecord() {
    }

    public UserRecord(String uid, long createTime) {
        this.uid = uid;
        this.createTime = createTime;
    }

    public String getUid() {
        return uid;
    }

    void setUid(String id) {
        uid = id;
    }

    public long getCreateTime() {
        return createTime;
    }

    void setCreateTime(long time) {
        this.createTime = time;
    }

    public static UserRecord newUserRecord(String uid) {
        UserRecord ur = new UserRecord();
        ur.uid = uid == null ? UUID.randomUUID().toString().toUpperCase().replaceAll("-", "") : uid;
        ur.createTime = System.currentTimeMillis();
        return ur;
    }

    @JsonIgnore
    public Long getCAS() {
        return CAS;
    }

    public void setCAS(long cas) {
        this.CAS = cas;
    }


    @JsonIgnore
    public Integer getTtlSec() {
        return ttlSec;
    }

    public void setTtlSec(int ttlSec) {
        this.ttlSec = ttlSec;
    }

    public Map<String, String> getThirdPartyIds() {
        return thirdPartyIds;
    }

    public void addThirdPartyId(String partnerId, String thirdPartyId) {
        if (partnerId != null && thirdPartyId != null) {
            thirdPartyIds.put(partnerId, thirdPartyId);
        }
    }

    public String getUidForPartner(String partnerId) {
        return thirdPartyIds.get(partnerId);
    }

    public boolean getHasChanges() {
        return hasChanges;
    }

    public void setHasChanges(boolean hasChanges) {
        this.hasChanges = hasChanges;
    }

    public String getEnvelope() {
        return envelope;
    }

    public void setEnvelope(String envelope) {
        this.envelope = envelope;
    }

    public Long getCreatedTS() {
        return createdTS;
    }

    public void setCreatedTS(Long createdTS) {
        this.createdTS = createdTS;
    }

    public Long getUpdatedTS() {
        return updatedTS;
    }

    public void setUpdatedTS(Long updatedTS) {
        this.updatedTS = updatedTS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRecord)) return false;
        UserRecord that = (UserRecord) o;
        return createTime == that.createTime &&
                hasChanges == that.hasChanges &&
                Objects.equals(uid, that.uid) &&
                Objects.equals(CAS, that.CAS) &&
                Objects.equals(ttlSec, that.ttlSec) &&
                Objects.equals(thirdPartyIds, that.thirdPartyIds) &&
                Objects.equals(envelope, that.envelope);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, createTime, CAS, ttlSec, thirdPartyIds, hasChanges, envelope);
    }

    @Override
    public String toString() {
        return "UserRecord [uid=" + uid + ", createTime=" + createTime
                + ", CAS=" + CAS + ", ttlSec=" + ttlSec + ", counters="
                + ", thirdPartyIds=" + thirdPartyIds + ", envelope=" + envelope + "]";
    }

    public boolean isGDPR() {
        return false;
    }

    public boolean isCCPA() {
        return false;
    }
}

