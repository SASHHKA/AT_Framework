package mapper.models;

import java.util.Objects;

public class CreateOrganizationResponse {

    private String id;
    private String name;
    private String displayName;
    private String desc;
    private String url;
    private String idList;
    private String idBoard;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return "CreateOrganizationResponse{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
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

    public String getIdList() {
        return idList;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateOrganizationResponse that = (CreateOrganizationResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(displayName, that.displayName) && Objects.equals(desc, that.desc) && Objects.equals(url, that.url) && Objects.equals(idList, that.idList) && Objects.equals(idBoard, that.idBoard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, displayName, desc, url, idList, idBoard);
    }
}
