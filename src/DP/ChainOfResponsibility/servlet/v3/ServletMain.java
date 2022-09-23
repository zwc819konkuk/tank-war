package DP.ChainOfResponsibility.servlet.v3;


import java.util.ArrayList;
import java.util.List;

/**
 * 想对response也进行过滤
 * v2: 这样写顺序不对 response的顺序
 * v3：在filterChain中加入位置的参数，然后在filter中加入第三个参数
 */
public class ServletMain {
    public static void main(String[] args) {
        Request request = new Request();
        request.str = "大家好:),<script>,欢迎访问zwc.com,996们";

        Response response = new Response();
        response.str = "response";

        FilterChain chain = new FilterChain();
        chain.add(new HTMLFilter()).add(new SensitiveFilter());
        chain.doFilter(request, response, chain);

        System.out.println(request.str);
        System.out.println(response.str);
    }
}


class Msg {
    String name;
    String msg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}

interface Filter {
    boolean doFilter(Request request, Response response, FilterChain chain);
}

class Request {
    String str;
}

class Response {
    String str;
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        request.str = request.str.replaceAll("<", "[").replaceAll(">", "]") + "HTML";
        chain.doFilter(request, response, chain);
        response.str += "--HTMLFilter";
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        request.str = request.str.replaceAll("996", "955") + "Sen";
        chain.doFilter(request, response, chain);
        response.str += "--SenFilter";
        return true;
    }
}

class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();
    int index = 0;

    public FilterChain add(Filter f) {
        filters.add(f);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response response, FilterChain chain) {
        if (index == filters.size()) return false;
        Filter f = filters.get(index);
        index++;
        return f.doFilter(request, response, chain);
    }
}