export const BASE_URL = "http://localhost:9090";
export const API_BASE_URL = BASE_URL + "/api/v1";
export const WEBSOCKET_URL = BASE_URL + "/websocket";

export const USER = "/user";
export const REGISTRATION = "/auth/registration";
export const CART = "/cart";
export const PERFUMES = "/products";

// admin
export const ADMIN_ADD = "/admin/add";
export const ADMIN_EDIT = "/admin/edit";
export const ADMIN_DELETE = "/admin/delete";
export const ADMIN_USER = "/admin/user";
export const ADMIN_USER_ALL = "/admin/user/all";
export const ADMIN_ORDER = "/admin/order";
export const ADMIN_ORDERS = "/admin/orders";
export const ADMIN_GRAPHQL_USER = "/admin/graphql/user";
export const ADMIN_GRAPHQL_USER_ALL = "/admin/graphql/user/all";
export const ADMIN_GRAPHQL_ORDERS = "/admin/graphql/orders";
export const ADMIN_GRAPHQL_ORDER = "/admin/graphql/order";

// auth
export const AUTH_LOGIN = "/auth/login";
export const AUTH_FORGOT = "/auth/forgot";
export const AUTH_RESET = "/auth/reset";
export const AUTH_EDIT_PASSWORD = "/auth/edit/password";
export const REGISTRATION_ACTIVATE = "/registration/activate";

// user
export const USERS_CART = "/users/cart";
export const USERS_ORDER = "/users/order";
export const USERS_ORDERS = "/users/orders";
export const USERS_INFO = "/users/info";
export const USERS_EDIT = "/users/edit";
export const USERS_REVIEW = "/users/review";
export const USERS_GRAPHQL_ORDERS = "/users/graphql/review";
export const USERS_GRAPHQL_INFO = "/users/graphql/info";

// perfumes
export const PERFUMES_IDS = "/products/ids";
export const PERFUMES_REVIEWS = "/products/reviews";
export const PERFUMES_SEARCH = "/products/search";
export const PERFUMES_SEARCH_GENDER = "/products/search/gender";
export const PERFUMES_SEARCH_PERFUMER = "/products/search/productr";
export const PERFUMES_SEARCH_TEXT = "/products/search/text";
export const PERFUMES_GRAPHQL_PERFUME = "/products/graphql/perfume";
export const PERFUMES_GRAPHQL_PERFUMES = "/products/graphql/products";
export const PERFUMES_GRAPHQL_IDS = "/products/graphql/ids";
