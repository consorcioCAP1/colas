package pe.com.certicom.scolas.scope;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;



public class FlashScopeFixerFilter implements Filter {
	
@Override
public void doFilter(final ServletRequest sreq, final ServletResponse srsp,
	      final FilterChain chain) throws IOException, ServletException {
	    final HttpServletRequest req = (HttpServletRequest) sreq;
	    final HttpServletResponse rsp = (HttpServletResponse) srsp;
	    final String pathInfo = pathInfo(req);

	    if (cacheForever(pathInfo)) {
	      rsp.setHeader("Cache-Control", "max-age=31536000,public");
	      rsp.setDateHeader("Expires", System.currentTimeMillis() + 31536000000L);
	    } else if (nocache(pathInfo)) {
	      rsp.setDateHeader("Expires", System.currentTimeMillis() + (30 * 24 * 60 * 60 * 1000L));
	      rsp.setHeader("Pragma", "no-cache");
	      rsp.setHeader("Cache-Control", "no-cache");
	      rsp.setHeader("Cache-Control", "no-store");
	      rsp.setHeader("Cache-Control", "no-cache, must-revalidate");
	    }

	    chain.doFilter(req, rsp);
	  }

@Override
public void init(FilterConfig arg0) throws ServletException {
	
}
@Override
public void destroy() {}

private static boolean cacheForever(final String pathInfo) {
    if (pathInfo.endsWith(".cache.gif")) {
      return true;
    }
    if (pathInfo.endsWith(".cache.html")) {
      return true;
    }
    if (pathInfo.endsWith(".cache.png")) {
      return true;
    }
    if (pathInfo.endsWith(".cache.jar")) {
      return true;
    }
    if (pathInfo.endsWith(".cache.swf")) {
      return true;
    }
    return false;
  }

  private static boolean nocache(final String pathInfo) {
    if (pathInfo.endsWith(".nocache.js")) {
      return true;
    }
    return false;
  }

  private static String pathInfo(final HttpServletRequest req) {
    final String uri = req.getRequestURI();
    final String ctx = req.getContextPath();
    return uri.startsWith(ctx) ? uri.substring(ctx.length()) : uri;
  }
}