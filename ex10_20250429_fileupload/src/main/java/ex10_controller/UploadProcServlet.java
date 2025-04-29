package ex10_controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 1, // 1MB 이상이면 디스크에 저장
		maxFileSize = 1024 * 1024 * 10, //최대 10MB 파일 업로드 허용
		maxRequestSize = 1024 * 1024 * 15 //요청 전체 크기 15MB제한
		)


@WebServlet("/uploadProc")
public class UploadProcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. upload 폴더 지정
		String uploadPath = request.getServletContext().getRealPath("/images/");
		System.out.println("uploadPath: " + uploadPath);
		
		// 2. 일반 파라미터 처리
		String desc = request.getParameter("desc");
		System.out.println("desc: " + desc );
		
		// 3. 파일처리
		Part part = request.getPart("imgfile");
		long size = part.getSize();
		if(size > 0) {
			part.write(uploadPath + part.getSubmittedFileName()) ;
			part.delete();
			request.setAttribute("filename", part.getSubmittedFileName());
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}else {
			response.sendRedirect("fail.jsp");
		}
		
		
		
		
		
		
	}

}
