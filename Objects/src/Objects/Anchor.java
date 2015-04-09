package Objects;

import java.sql.Timestamp;

/**
 * Created by karolsudol on 06/04/15.
 */
public class Anchor {
    private Domain domain;
    private String anchorHash;
    private String anchorUrl;
    private int scanStatus;
    private boolean activated;
    private Timestamp modified;
    private Timestamp created;

    public Domain getDomain() {
        return domain;
    }

    public String getAnchorHash() {
        return anchorHash;
    }

    public String getAnchorUrl() {
        return anchorUrl;
    }

    public int getScanStatus() {
        return scanStatus;
    }

    public boolean isActivated() {
        return activated;
    }

    public Timestamp getModified() {
        return modified;
    }

    public Timestamp getCreated() {
        return created;
    }


    public Anchor(Domain domain,  String anchorUrl) throws Exception {
        this.domain = domain;
        this.anchorHash = Hasher.toSha256(anchorUrl);
        this.anchorUrl = anchorUrl;
        this.scanStatus = 0;
        this.modified = CommonFunc.getTimestamp();
        this.activated = true;
        this.created = CommonFunc.getTimestamp();

    }


    public Anchor(Domain domain, String anchorHash, String anchorUrl) {
        this.domain = domain;
        this.anchorHash = anchorHash;
        this.anchorUrl = anchorUrl;
    }

    /**
     *
     * database methods
     *
     * @param domain
     * @param anchorHash
     * @param anchorUrl
     * @param scanStatus
     * @param activated
     * @param modified
     * @param created
     */

    public Anchor(Domain domain, String anchorHash, String anchorUrl, int scanStatus, boolean activated, Timestamp modified, Timestamp created) {
        this.domain = domain;
        this.anchorHash = anchorHash;
        this.anchorUrl = anchorUrl;
        this.scanStatus = scanStatus;
        this.activated = activated;
        this.modified = modified;
        this.created = created;
    }
}
