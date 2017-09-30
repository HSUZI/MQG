package com.qingqu.wc.maqi.bean;

import java.util.List;



public class ShopCartBean {

    /**
     * shopId : 2
     * shopName : null
     * cartlist : [{"id":2,"shopId":2,"shopName":null,"productId":2,"productName":null,"color":null,"size":null,"price":null,"count":null}]
     */

    private int shopId;
    private Object shopName;
    /**
     * id : 2
     * shopId : 2
     * shopName : null
     * productId : 2
     * productName : null
     * color : null
     * size : null
     * price : null
     * count : null
     */

    private List<CartlistBean> cartlist;


    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public Object getShopName() {
        return shopName;
    }

    public void setShopName(Object shopName) {
        this.shopName = shopName;
    }

    public List<CartlistBean> getCartlist() {
        return cartlist;
    }

    public void setCartlist(List<CartlistBean> cartlist) {
        this.cartlist = cartlist;
    }


    public static class CartlistBean {
        private int id;
        private int shopId;
        private String shopName;
        private int productId;
        private String productName;
        private String color;
        private String size;
        private String price;
        private int defaultPic;
        private int count;
        private boolean isSelect = true;
        private int isFirst = 2;
        private boolean isShopSelect = true;
        private boolean ShopBj = false;
        private boolean ShopBjss = false;


        public int getDefaultPic() {
            return defaultPic;
        }

        public void setDefaultPic(int defaultPic) {
            this.defaultPic = defaultPic;
        }

        public boolean getIsShopSelect() {
            return isShopSelect;
        }
        public boolean getShopBj() {
            return ShopBj;
        }
        public boolean getShopBjss() {
            return ShopBjss;
        }
        public void setShopSelect(boolean shopSelect) {
            isShopSelect = shopSelect;
        }
        public void setShopBj(boolean bj){
            ShopBj=bj;
        }
        public void setShopBjss(boolean bj){
            ShopBjss=bj;
        }
        public int getIsFirst() {
            return isFirst;
        }

        public void setIsFirst(int isFirst) {
            this.isFirst = isFirst;
        }

        public boolean getIsSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
