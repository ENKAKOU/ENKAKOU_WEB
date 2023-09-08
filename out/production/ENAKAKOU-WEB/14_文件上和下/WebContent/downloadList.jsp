<%@page import="java.io.File"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>树型遍历</h1>
<%
    Queue<File> queue = new LinkedList<File>();	//创建一个队列
    File root = new File("E://resource");       //先将跟节点入队
    queue.offer(root);
    //判断这个队列是否为空，不能空需要进行遍历
    while(!queue.isEmpty()){
        File file = queue.poll();               // 将跟节点出队
        File[] files = file.listFiles();     	// 获得跟节点下的所有子节点
        for(File f:files){                      // 遍历所有子节点
            if(f.isFile()){			            // 判断该节点是否为叶子节点
%>
<h4><a href="${ pageContext.request.contextPath }/DownloadListServlet?filename=<%=
       f.getCanonicalPath()%>"><%= f.getName() %></a></h4>
<%
    }else{
                queue.offer(f);
    }
        }
    }
%>

</body>
</html>