package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import vo.FileVO;
import vo.companyVo;
import dao.companyDao;

/**
 * Servlet implementation class manageCountry
 */
@WebServlet("/manageCompany")
@MultipartConfig
public class manageCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public manageCompany() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String f1 = request.getParameter("flag1");
		if (f1.equals("delete")) 
		{
			delete(request, response);
			search(request, response);
		}
		else if (f1.equals("edit")) 
		{
			edit(request, response);
		}
		else if (f1.equals("Search")) 
		{

			search(request, response);
		}
		else if (f1.equals("Insert")) 
		{
			insert(request, response);
		}
		else if(f1.equals("viewDetails"))
		{
			viewDetails(request,response);
		}
	}

	private void viewDetails(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession h = request.getSession();
		FileVO fvo = new FileVO();
		fvo.setFileid(id);
		companyDao cdo = new companyDao();
		List ls = new ArrayList();
		ls = cdo.viewDetails(fvo);
		h.setAttribute("List", ls);
		response.sendRedirect("user/LIC.jsp");
	}

	private void edit(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		int i1 = Integer.parseInt(request.getParameter("id"));
		HttpSession h = request.getSession();
		companyVo covo = new companyVo();
		covo.setCompany_ID(i1);
		companyDao cdo = new companyDao();
		List ls = new ArrayList();
		ls = cdo.edit(covo);
		h.setAttribute("List", ls);
		response.sendRedirect("admin/editCompany.jsp");

	}

	private void insert(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		HttpSession h = request.getSession();
		companyDao cdo = new companyDao();
        FileVO fileVO = new FileVO();
        List ls = cdo.searchfile(fileVO);
		h.setAttribute("list", ls);
		response.sendRedirect("user/BrowsePolicy.jsp");

	}

	private void search(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		HttpSession h = request.getSession();
		companyDao cdo = new companyDao();
		List<companyVo> ls = null;
		ls = cdo.search();
		h.setAttribute("List", ls);
		response.sendRedirect("admin/viewCompany.jsp");

	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		int i1 = Integer.parseInt(request.getParameter("id"));
		HttpSession h = request.getSession();
		companyVo covo = new companyVo();
		covo.setCompany_ID(i1);
		companyDao cdo = new companyDao();
		List ls = new ArrayList();
		ls = cdo.delete(covo);
		h.setAttribute("List", ls);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String f = request.getParameter("flag");
		if (f.equals("Submit")) {
			save(request, response);
			//search(request, response);
		} else if (f.equals("Update")) {
			update(request, response);
			search(request, response);
		}

	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String companyName = request.getParameter("companyName");
		int i2 = Integer.parseInt(request.getParameter("companyID"));
		String des = request.getParameter("companyDescription");
		companyVo covo = new companyVo();
		covo.setCompany_ID(i2);
		covo.setCompanyDes(des);
		covo.setCompanyName(companyName);
		companyDao cdo = new companyDao();
		cdo.update(covo);

	}

	private void save(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String companyName = request.getParameter("Company");
		String des = request.getParameter("companyDes");
		companyVo covo = new companyVo();
		covo.setCompanyDes(des);
		covo.setCompanyName(companyName);
		covo.setCompanyStatus("Active");
		companyDao cdo = new companyDao();
		cdo.insert(covo);

		for(Part filePart : request.getParts())
		{
			if(filePart.getSubmittedFileName()!=null && !filePart.getSubmittedFileName().equals(""))
			{
				String fileName = filePart.getSubmittedFileName();
				InputStream fileContent = filePart.getInputStream();
				// ... (do your job here)

				byte[] buffer = new byte[fileContent.available()];
				fileContent.read(buffer);

				String filePath = getServletContext().getRealPath(request.getServletPath());

				System.out.println("filepath :: "+filePath);

				int path = filePath.lastIndexOf('\\');
				String path1= filePath.substring(0, path) + "/doc/";
				System.out.println("XC");

				/*File targetFile = new File(path1+fileName);
				OutputStream outStream = new FileOutputStream(targetFile);
				outStream.write(buffer);*/

				//uncoment this if you want to encrypt name of file n coment above 3 line
				String encryptedFileName=encryptFileName(fileName);
				File targetEncryptFile = new File(path1+encryptedFileName);

				OutputStream outStream = new FileOutputStream(targetEncryptFile);
				outStream.write(buffer);

				System.out.println("File Output Path :: "+path1+fileName);

				FileVO fileVO = new FileVO();
				fileVO.setFilename(fileName);
				fileVO.setFilepath(encryptedFileName);
				fileVO.setCvo(covo);

				cdo.insertFile(fileVO);
				response.sendRedirect("admin/company.jsp");

			}
		}

	}

	private String encryptFileName(String fileName) {
		// TODO Auto-generated method stub

		Random r = new Random();
		String file[] = fileName.split("\\.");

		byte[] unencodedFile = file[0].getBytes();
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
		}
		md.reset();
		md.update(unencodedFile);
		byte[] encodedFile = md.digest();
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < encodedFile.length; i++) {
			if (((int) encodedFile[i] & 0xff) < 0x10) {
				buf.append("0");
			}
			buf.append(Long.toString((int) encodedFile[i] & 0xff, 16));
		}

		String encryptedFileName = (buf.toString()).concat(String.valueOf(r
				.nextInt()));

		return encryptedFileName + "." + file[file.length - 1];

	}

}
