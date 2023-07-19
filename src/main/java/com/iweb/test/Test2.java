package com.iweb.test;

import com.iweb.view.View;

/**
 * @author YangXinYue
 * @date 2023/7/18 17:58
 */
public class Test2 {


    public static void main(String[] args) {
        //    测试普通用户登录和注册
        View v = new View();
        v.ask();
    }
}






//以下两个部分都没有修改字段！！！！！
//暂存ProductDAO
//    /**增加商品数据 （管理员）
//     * @param p
//     */
//    void insert(Product p);
//
//
//    /**删除商品数据 （管理员）
//     * @param p 根据productName或productId 删除
//     */
//    void delete(Product p);
//
//
//    /**更新商品信息 （管理员）
//     * @param p
//     */
//    void update(Product p);
//
//
//    /**查询商品数据信息（用户和管理员）
//     * @param productName
//     * @return
//     */
//    List<Product> list(String productName);


//其实现类ProductDAOImpl
//    @Override
//    public void insert(Product p) {
//        String sql = "insert into product(productName,reviews,statsID,productPrice) values(?,?,?,?)";
//        try(
//                Connection c = DBUtil.getConnection();
//                PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//        ){
//            if (p == null||p.getProductName()==null||p.getProductName().equals("")||p.getStatsID()<1||p.getProductPrice()<0){
//                System.out.println("参数有误，请检查");
//                return;
//            }
//            ps.setString(1,p.getProductName());
//            ps.setInt(2,p.getReviews());
//            ps.setInt(3,p.getStatsID());
//            ps.setInt(4,p.getProductPrice());
//            ps.execute();
//            ResultSet rs = ps.getGeneratedKeys();
//            if (rs.next()){
//                int id = rs.getInt(1);
//                p.setProductID(id);
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void delete(Product p) {
//        String sql = "delete from products where 1=1";
//        if (p == null){
//            System.out.println("参数有误 请检查");
//            return;
//        }
//        if (p.getProductID()>0&&p.getProductName()==null||(p.getProductName().equals(""))){
//            sql = sql+"and productID = ?";
//            try(
//                    Connection c = DBUtil.getConnection();
//                    PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            ){
//                ps.setInt(1,p.getProductID());
//                ps.execute();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }else if (p.getProductID()<=0&&p.getProductName()!=null&&!(p.getProductName().equals(""))){
//           sql = sql +"and productName = ?";
//            try(
//                    Connection c = DBUtil.getConnection();
//                    PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            ){
//                ps.setString(1,p.getProductName());
//                ps.execute();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//
//    }
//
//    @Override
//    public void update(Product p) {
//        if(p==null||p.getProductName()==null||p.getProductName().equals("")||p.getProductID()<0){
//            System.out.println("参数有误 请检查");
//            return;
//        }
//        String sql = "update products set productName = ? where productID = ?";
//        try (Connection c = DBUtil.getConnection();
//             PreparedStatement ps = c.prepareStatement(sql)
//        ){
//            ps.setString(1,p.getProductName());
//            ps.setInt(2,p.getProductID());
//            ps.execute();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//
//    @Override
//    public List<Product> list(String productName) {
//        List<Product> productList = new ArrayList<>();
//        String sql = "select * from products where productName like concat('%',?,'%')";
//        try (
//                Connection c = DBUtil.getConnection();
//             PreparedStatement ps = c.prepareStatement(sql);
//        ) {
//            ps.setString(1,productName);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()){
//                Product p = new Product(
//                        rs.getInt(1),
//                        rs.getString(2),
//                        rs.getInt(3),
//                        rs.getInt(4),
//                        rs.getInt(5)
//                );
//                productList.add(p);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return productList.isEmpty()?null: productList;
//    }