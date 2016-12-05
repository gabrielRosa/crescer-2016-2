package br.com.cwi.crescer.filtro;

// @author Gabriel
//public class SessionFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        LOGGER.info("init filter");
//    }
//
//    @Override
//    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
//        process((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse);
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//
//    @Override
//    public void destroy() {
//        LOGGER.info("destroy filter");
//    }
//
//    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        final HttpSession session = request.getSession();
//        final UserDetails user = (UserDetails) session.getAttribute(USER_AUTH);
//        if (!request.getRequestURI().contains("login.xhtml") && user == null) {
//            response.sendRedirect(request.getContextPath() + "/faces/criar_login.xhtml");
//        }
//    }
//}
