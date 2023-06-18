export interface Sort {
    empty: boolean;
    sorted: boolean;
    unsorted: boolean;
  }
  
  export interface Pageable {
    sort: Sort;
    offset: number;
    pageNumber: number;
    pageSize: number;
    unpaged: boolean;
    paged: boolean;
  }
  
  
  export interface Page<T> {
    content: T[];
    pageable?: Pageable;
    last?: boolean;
    totalPages: number;
    totalElements: number;
    number?: number;
    size?: number;
    sort?: Sort;
    first?: boolean;
    numberOfElements?: number;
    empty?: boolean;
  }