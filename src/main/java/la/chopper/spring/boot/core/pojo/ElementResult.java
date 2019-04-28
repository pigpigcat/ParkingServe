package la.chopper.spring.boot.core.pojo;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

/**
 * element-ui 分页对象
 *
 * @author TonyTonyChopper
 * @version 1.0
 */
public class ElementResult implements Serializable {

    private static final long serialVersionUID = 538318380121300894L;

    /**
     * 每页的数量
     */
    private Integer pageSize;
    /**
     * 当前页
     */
    private Integer pageNumber;

    /**
     * 结果集
     */
    private List rows;
    /**
     * 总页数
     */
    private Long total;

    public ElementResult(List rows, Long total) {
        this.rows = rows;
        this.total = total;
    }

    public ElementResult(Integer pageSize, Integer pageNumber, List rows, Long total) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.rows = rows;
        this.total = total;
    }

    public ElementResult() {
    }

    public ElementResult(PageInfo pageInfo) {
        this.rows = pageInfo.getList();
        this.total = pageInfo.getTotal();
        this.pageNumber = pageInfo.getPageNum();
        this.pageSize = pageInfo.getSize();
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ElementResult.class.getSimpleName() + "[", "]")
                .add("pageSize=" + pageSize)
                .add("pageNumber=" + pageNumber)
                .add("rows=" + rows)
                .add("total=" + total)
                .toString();
    }
}
