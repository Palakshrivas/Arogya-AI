package backend.backend.dto;

import java.util.List;

public class PaginatedResponse<T> extends PageResponse<T> {

    public PaginatedResponse() {
        super();
    }

    public PaginatedResponse(List<T> content, int pageNumber, int pageSize, long totalElements, int totalPages, boolean last) {
        super(content, pageNumber, pageSize, totalElements, totalPages, last);
    }
}
