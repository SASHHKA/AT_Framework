package mapper.models;

import java.util.Objects;

public class GetOrganizationResponse {
    String id;
    String linkName;
    String displayName;
    String desc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return linkName;
    }

    public void setName(String linkName) {
        this.linkName = linkName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetOrganizationResponse that = (GetOrganizationResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(linkName, that.linkName) && Objects.equals(displayName, that.displayName) && Objects.equals(desc, that.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, linkName, displayName, desc);
    }

    @Override
    public String toString() {
        return "GetOrganizationResponse{" +
                "id='" + id + '\'' +
                ", name='" + linkName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
