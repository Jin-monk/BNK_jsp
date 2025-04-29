package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.Order;
import vo.OrderList;
import vo.PCodeList;
import vo.ShopOrderList;

public class OrderDao {

	private PreparedStatement pstmt;
	private ResultSet rs;
	private Connection conn;
	DBConn dbconn = new DBConn();

	public OrderDao() {
		conn = dbconn.getConnection();
	}

	public void insert(Order order) throws SQLException {
		String query = "INSERT INTO TBL_ORDER VALUES(?, ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(query);

		pstmt.setString(1, order.getOrderNo());
		pstmt.setString(2, order.getShopNo());
		pstmt.setString(3, order.getOrderDate());
		pstmt.setString(4, order.getPCode());
		pstmt.setString(5, order.getAmount());

		pstmt.executeUpdate();

	}

	public List<OrderList> selectAll() throws SQLException {
		List<OrderList> oList = new ArrayList<>();
		
		String query = "SELECT S.SHOPNO AS 할인점코드, SHOPNAME AS 점포명, ORDERNO AS 주문번호, TO_DATE(ORDERDATE,'YYYY-MM-DD') AS 주문일자, P.PCODE AS 제품코드, PNAME AS 제품명, AMOUNT AS 주문수량 , COST AS 단가, (COST*AMOUNT) AS 소비자가격,  COST * AMOUNT * (1-DISCOUNT/100) AS 할인가격 FROM TBL_PRODUCT P INNER JOIN TBL_ORDER O ON P.PCODE = O.PCODE INNER JOIN TBL_SHOP S ON O.SHOPNO = S.SHOPNO";
	
		pstmt = conn.prepareStatement(query);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			 OrderList orderList = new OrderList();
			 orderList.setShopNo(rs.getString("할인점코드"));
			 orderList.setShopName(rs.getString("점포명"));
			 orderList.setOrderNo(rs.getString("주문번호"));
			 orderList.setOrderDate(rs.getString("주문일자"));
			 orderList.setPCode(rs.getString("제품코드"));
			 orderList.setPName(rs.getString("제품명"));
			 orderList.setAmount(rs.getString("주문수량"));
			 orderList.setCost(rs.getString("단가"));
			 orderList.setCustPrice(rs.getString("소비자가격"));
			 orderList.setDisPrice(rs.getString("할인가격"));
			 
			 oList.add(orderList);
		}
		return oList;
	}

	public List<Order> selectByONo(Order order) throws SQLException {
		List<Order> oList = new ArrayList<>();
		String query = "SELECT * FROM TBL_ORDER WHERE orderNo = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, order.getOrderNo());
		rs = pstmt.executeQuery();
		while (rs.next()) {
			order = new Order();

			order.setOrderNo(rs.getString("orderNo"));
			order.setShopNo(rs.getString("shopNo"));
			order.setOrderDate(rs.getString("orderDate"));
			order.setPCode(rs.getString("pCode"));
			order.setAmount(rs.getString("amount"));

			oList.add(order);
		}
		return oList;
	}

	//점포별 주문현황
	public List<ShopOrderList> selectByShopNo() throws SQLException {
		List<ShopOrderList> sOList = new ArrayList<>();
		ShopOrderList sOL = new ShopOrderList();
		String query = "SELECT O.SHOPNO AS 할인점코드, P.PCODE AS 제품코드 , PNAME AS 제품명, SUM(AMOUNT) AS 주문총수량 FROM TBL_ORDER O JOIN TBL_PRODUCT P ON  O.PCODE = P.PCODE GROUP BY O.SHOPNO, P.PCODE, PNAME ORDER BY O.SHOPNO";
		Statement stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
		while (rs.next()) {
			sOL = new ShopOrderList();

			sOL.setSCode(rs.getString("할인점코드"));
			sOL.setPCode(rs.getString("제품코드"));
			sOL.setPName(rs.getString("제품명"));
			sOL.setAllAmount(rs.getString("주문총수량"));

			sOList.add(sOL);
		}
		return sOList;
	}
	
	
	//제품코드조회
	public List<PCodeList> selectByPCodeList() throws SQLException {
		List<PCodeList> pCList = new ArrayList<>();
		PCodeList pCL = new PCodeList();
		String query = "SELECT PCODE AS 제품코드, PNAME AS 제품명, COST AS 단가, (COST*0.9) AS \"할인율(10%)\", (COST*0.85) AS \"할인율(15%)\" FROM TBL_PRODUCT";
		Statement stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
		while (rs.next()) {
			pCL = new PCodeList();

			pCL.setPCode(rs.getString("제품코드"));
			pCL.setPName(rs.getString("제품명"));
			pCL.setCost(rs.getString("단가"));
			pCL.setDiscount10(rs.getString("할인율(10%)"));
			pCL.setDiscount15(rs.getString("할인율(15%)"));

			pCList.add(pCL);
		}
		return pCList;
	}
	
	
	public void update() {

	}

	public void delete() {

	}
}
