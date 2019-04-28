package la.chopper.spring.boot.core.domain;

import java.util.List;
import java.util.StringJoiner;

/**
 * 前端动态路由
 *
 * @author TonyTonyChopper
 */
public class RouteConfig {

    private int id;
    private String name;
    private int code;
    private String description;
    private String url;
    private int generatemenu;
    private int sort;
    private int parentId;
    private String permName;
    private String redirect;
    private String title;
    private String icon;
    private List<RouteConfig> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getGeneratemenu() {
        return generatemenu;
    }

    public void setGeneratemenu(int generatemenu) {
        this.generatemenu = generatemenu;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<RouteConfig> getChildren() {
        return children;
    }

    public void setChildren(List<RouteConfig> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RouteConfig.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("code=" + code)
                .add("description='" + description + "'")
                .add("url='" + url + "'")
                .add("generatemenu=" + generatemenu)
                .add("sort=" + sort)
                .add("parentId=" + parentId)
                .add("permName='" + permName + "'")
                .add("redirect='" + redirect + "'")
                .add("title='" + title + "'")
                .add("icon='" + icon + "'")
                .add("children=" + children)
                .toString();
    }
}
