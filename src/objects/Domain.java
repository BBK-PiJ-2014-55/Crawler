package Objects;

import java.sql.Timestamp;

/**
 * Created by karolsudol on 06/04/15.
 */
public class Domain {
    private String domainHash;
    private String domainUrl;
    private boolean activated;
    private Timestamp crated;
    private Timestamp modified;

    public String getDomainHash() {
        return domainHash;
    }

    public String getDomainUrl() {
        return domainUrl;
    }

    public boolean isActivated() {
        return activated;
    }

    public Timestamp getCrated() {
        return crated;
    }

    public Timestamp getModified() {
        return modified;
    }

    public Domain(String domainHash, String domainUrl) {
        this.domainHash = domainHash;
        this.domainUrl = domainUrl;
    }

    /**
     *
     * database methods
     *
     * @param domainHash
     * @param domainUrl
     * @param activated
     * @param crated
     * @param modified
     */

    public Domain(String domainHash, String domainUrl, boolean activated, Timestamp crated, Timestamp modified) {
        this.domainHash = domainHash;
        this.domainUrl = domainUrl;
        this.activated = activated;
        this.crated = crated;
        this.modified = modified;
    }
}
