package com.example.zll.jingdongrxjava.bean;

import java.util.List;

/**
 * Created by zll on 2018/5/17.
 */

public class GetCartsBean {
    /**
     * msg : 请求成功
     * code : 0
     * data : [{"list":[{"bargainPrice":6666,"createtime":"2017-10-10T16:01:31","detailUrl":"https://item.m.jd
     * .com/product/5089273.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term
     * =QQfriends","images":"https://m.360buyimg
     * .com/n0/jfs/t8284/363/1326459580/71585/6d3e8013/59b857f2N6ca75622.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t9346/182/1406837243/282106/68af5b54/59b8480aNe8af7f5c.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t8434/54/1359766007/56140/579509d9/59b85801Nfea207db.jpg!q70.jpg","num":2,"pid":46,"price":234,
     * "pscid":39,"selected":1,"sellerid":2,"subhead":"【iPhone新品上市】新一代iPhone，让智能看起来更不一样","title":"Apple iPhone 8 Plus
     * (A1864) 64GB 金色 移动联通电信4G手机"},{"bargainPrice":11800,"createtime":"2017-10-14T21:38:26",
     * "detailUrl":"https://item.m.jd.com/product/5025518.html?utm#_source=androidapp&utm#_medium=appshare&utm
     * #_campaign=t#_335139774&utm#_term=QQfriends","images":"https://m.360buyimg
     * .com/n0/jfs/t8830/106/1760940277/195595/5cf9412f/59bf2ef5N5ab7dc16.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t5428/70/1520969931/274676/b644dd0d/591128e7Nd2f70da0.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t5566/365/1519564203/36911/620c750c/591128eaN54ac3363.jpg!q70.jpg","num":7,"pid":58,"price":6399,
     * "pscid":40,"selected":1,"sellerid":2,"subhead":"升级4G大显存！Nvme协议Pcie SSD,速度快人一步】GTX1050Ti就选拯救者！专业游戏键盘&新模具全新设计！",
     * "title":"联想(Lenovo)拯救者R720 15.6英寸游戏笔记本电脑(i5-7300HQ 8G 1T+128G SSD GTX1050Ti 4G IPS 黑)"}],"sellerName":"商家2",
     * "sellerid":"2"},{"list":[{"bargainPrice":22.9,"createtime":"2017-10-03T23:53:28","detailUrl":"https://item.m
     * .jd.com/product/2542855.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term
     * =QQfriends","images":"https://m.360buyimg
     * .com/n0/jfs/t1930/284/2865629620/390243/e3ade9c4/56f0a08fNbd3a1235.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t2137/336/2802996626/155915/e5e90d7a/56f0a09cN33e01bd0.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t1882/31/2772215910/389956/c8dbf370/56f0a0a2Na0c86ea6.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t2620/166/2703833710/312660/531aa913/57709035N33857877.jpg!q70.jpg","num":1,"pid":26,"price":88,
     * "pscid":2,"selected":1,"sellerid":3,"subhead":"三只松鼠零食特惠，专区满99减50，满199减100，火速抢购》","title":"三只松鼠 坚果炒货 零食奶油味
     * 碧根果225g/袋"}],"sellerName":"商家3","sellerid":"3"},{"list":[{"bargainPrice":22.9,
     * "createtime":"2017-10-14T21:38:26","detailUrl":"https://item.m.jd
     * .com/product/2542855.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term
     * =QQfriends","images":"https://m.360buyimg
     * .com/n0/jfs/t1930/284/2865629620/390243/e3ade9c4/56f0a08fNbd3a1235.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t2137/336/2802996626/155915/e5e90d7a/56f0a09cN33e01bd0.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t1882/31/2772215910/389956/c8dbf370/56f0a0a2Na0c86ea6.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t2620/166/2703833710/312660/531aa913/57709035N33857877.jpg!q70.jpg","num":2,"pid":27,"price":488,
     * "pscid":2,"selected":1,"sellerid":4,"subhead":"三只松鼠零食特惠，专区满99减50，满199减100，火速抢购》","title":"三只松鼠 坚果炒货 零食奶油味
     * 碧根果225g/袋"},{"bargainPrice":11800,"createtime":"2017-10-14T21:48:08","detailUrl":"https://mitem.jd
     * .hk/ware/view.action?wareId=1988853309&cachekey=1acb07a701ece8d2434a6ae7fa6870a1",
     * "images":"https://m.360buyimg.com/n0/jfs/t6130/97/1370670410/180682/1109582a/593276b1Nd81fe723.jpg!q70.jpg
     * |https://m.360buyimg.com/n0/jfs/t5698/110/2617517836/202970/c9388feb/593276b7Nbd94ef1f
     * .jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5698/110/2617517836/202970/c9388feb/593276b7Nbd94ef1f
     * .jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5815/178/2614671118/51656/7f52d137/593276c7N107b725a
     * .jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5878/60/2557817477/30873/4502b606/593276caN5a7d6357.jpg!q70.jpg",
     * "num":2,"pid":60,"price":13888,"pscid":40,"selected":1,"sellerid":4,"subhead":"购买电脑办公部分商品满1元返火车票5元优惠券（返完即止）",
     * "title":"全球购 新款Apple MacBook Pro 苹果笔记本电脑 银色VP2新13英寸Bar i5/8G/256G"}],"sellerName":"商家4","sellerid":"4"},
     * {"list":[{"bargainPrice":22.9,"createtime":"2017-10-03T23:53:28","detailUrl":"https://item.m.jd
     * .com/product/2542855.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term
     * =QQfriends","images":"https://m.360buyimg
     * .com/n0/jfs/t1930/284/2865629620/390243/e3ade9c4/56f0a08fNbd3a1235.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t2137/336/2802996626/155915/e5e90d7a/56f0a09cN33e01bd0.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t1882/31/2772215910/389956/c8dbf370/56f0a0a2Na0c86ea6.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t2620/166/2703833710/312660/531aa913/57709035N33857877.jpg!q70.jpg","num":1,"pid":31,"price":788,
     * "pscid":2,"selected":1,"sellerid":8,"subhead":"三只松鼠零食特惠，专区满99减50，满199减100，火速抢购》","title":"三只松鼠 坚果炒货 零食奶油味
     * 碧根果225g/袋"},{"bargainPrice":3455,"createtime":"2017-10-03T23:53:28","detailUrl":"https://item.m.jd
     * .com/product/12224420750.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term
     * =QQfriends","images":"https://m.360buyimg
     * .com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t8461/5/1492479653/68388/7255e013/59ba5e84N91091843.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t8803/356/1478945529/489755/2a163ace/59ba5e84N7bb9a666.jpg!q70.jpg","num":1,"pid":52,"price":666,
     * "pscid":39,"selected":1,"sellerid":8,"subhead":"【现货新品抢购】全面屏2.0震撼来袭，骁龙835处理器，四曲面陶瓷机","title":"小米（MI） 小米MIX2 手机
     * 黑色 全网通 (6GB+64GB)【标配版】"}],"sellerName":"商家8","sellerid":"8"},{"list":[{"bargainPrice":11800,
     * "createtime":"2017-10-03T23:53:28","detailUrl":"https://mitem.jd.hk/ware/view
     * .action?wareId=1988853309&cachekey=1acb07a701ece8d2434a6ae7fa6870a1","images":"https://m.360buyimg
     * .com/n0/jfs/t6130/97/1370670410/180682/1109582a/593276b1Nd81fe723.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t5698/110/2617517836/202970/c9388feb/593276b7Nbd94ef1f.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t5698/110/2617517836/202970/c9388feb/593276b7Nbd94ef1f.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t5815/178/2614671118/51656/7f52d137/593276c7N107b725a.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t5878/60/2557817477/30873/4502b606/593276caN5a7d6357.jpg!q70.jpg","num":1,"pid":67,"price":14000,
     * "pscid":40,"selected":1,"sellerid":11,"subhead":"购买电脑办公部分商品满1元返火车票5元优惠券（返完即止）","title":"全球购 新款Apple MacBook
     * Pro 苹果笔记本电脑 银色VP2新13英寸Bar i5/8G/256G"}],"sellerName":"商家11","sellerid":"11"},{"list":[{"bargainPrice":111.99,
     * "createtime":"2017-10-14T21:39:05","detailUrl":"https://item.m.jd
     * .com/product/4719303.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term
     * =QQfriends","images":"https://m.360buyimg
     * .com/n0/jfs/t9004/210/1160833155/647627/ad6be059/59b4f4e1N9a2b1532.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t7504/338/63721388/491286/f5957f53/598e95f1N7f2adb87.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t7441/10/64242474/419246/adb30a7d/598e95fbNd989ba0a.jpg!q70.jpg","num":1,"pid":20,"price":599,
     * "pscid":1,"selected":1,"sellerid":13,
     * "subhead":"每个中秋都不能简单，无论身在何处，你总需要一块饼让生活更圆满，京东月饼让爱更圆满京东自营，闪电配送，更多惊喜，快用手指戳一下","title":"北京稻香村 稻香村中秋节月饼
     * 老北京月饼礼盒655g"}],"sellerName":"商家13","sellerid":"13"},{"list":[{"bargainPrice":111.99,
     * "createtime":"2017-10-14T21:39:05","detailUrl":"https://item.m.jd
     * .com/product/4719303.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term
     * =QQfriends","images":"https://m.360buyimg
     * .com/n0/jfs/t9004/210/1160833155/647627/ad6be059/59b4f4e1N9a2b1532.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t7504/338/63721388/491286/f5957f53/598e95f1N7f2adb87.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t7441/10/64242474/419246/adb30a7d/598e95fbNd989ba0a.jpg!q70.jpg","num":2,"pid":1,"price":118,
     * "pscid":1,"selected":1,"sellerid":17,
     * "subhead":"每个中秋都不能简单，无论身在何处，你总需要一块饼让生活更圆满，京东月饼让爱更圆满京东自营，闪电配送，更多惊喜，快用手指戳一下","title":"北京稻香村 稻香村中秋节月饼
     * 老北京月饼礼盒655g"}],"sellerName":"商家17","sellerid":"17"},{"list":[{"bargainPrice":111.99,
     * "createtime":"2017-10-14T21:39:05","detailUrl":"https://item.m.jd
     * .com/product/4719303.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term
     * =QQfriends","images":"https://m.360buyimg
     * .com/n0/jfs/t9004/210/1160833155/647627/ad6be059/59b4f4e1N9a2b1532.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t7504/338/63721388/491286/f5957f53/598e95f1N7f2adb87.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t7441/10/64242474/419246/adb30a7d/598e95fbNd989ba0a.jpg!q70.jpg","num":2,"pid":2,"price":299,
     * "pscid":1,"selected":1,"sellerid":18,
     * "subhead":"每个中秋都不能简单，无论身在何处，你总需要一块饼让生活更圆满，京东月饼让爱更圆满京东自营，闪电配送，更多惊喜，快用手指戳一下","title":"北京稻香村 稻香村中秋节月饼
     * 老北京月饼礼盒655g"},{"bargainPrice":11800,"createtime":"2017-10-03T23:53:28","detailUrl":"https://mitem.jd
     * .hk/ware/view.action?wareId=1988853309&cachekey=1acb07a701ece8d2434a6ae7fa6870a1",
     * "images":"https://m.360buyimg.com/n0/jfs/t6130/97/1370670410/180682/1109582a/593276b1Nd81fe723.jpg!q70.jpg
     * |https://m.360buyimg.com/n0/jfs/t5698/110/2617517836/202970/c9388feb/593276b7Nbd94ef1f
     * .jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5698/110/2617517836/202970/c9388feb/593276b7Nbd94ef1f
     * .jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5815/178/2614671118/51656/7f52d137/593276c7N107b725a
     * .jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5878/60/2557817477/30873/4502b606/593276caN5a7d6357.jpg!q70.jpg",
     * "num":1,"pid":74,"price":35999,"pscid":40,"selected":1,"sellerid":18,"subhead":"购买电脑办公部分商品满1元返火车票5元优惠券（返完即止）",
     * "title":"全球购 新款Apple MacBook Pro 苹果笔记本电脑 银色VP2新13英寸Bar i5/8G/256G"}],"sellerName":"商家18","sellerid":"18"},
     * {"list":[{"bargainPrice":11800,"createtime":"2017-10-14T21:38:26","detailUrl":"https://mitem.jd.hk/ware/view
     * .action?wareId=1988853309&cachekey=1acb07a701ece8d2434a6ae7fa6870a1","images":"https://m.360buyimg
     * .com/n0/jfs/t6130/97/1370670410/180682/1109582a/593276b1Nd81fe723.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t5698/110/2617517836/202970/c9388feb/593276b7Nbd94ef1f.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t5698/110/2617517836/202970/c9388feb/593276b7Nbd94ef1f.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t5815/178/2614671118/51656/7f52d137/593276c7N107b725a.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t5878/60/2557817477/30873/4502b606/593276caN5a7d6357.jpg!q70.jpg","num":7,"pid":75,"price":36999,
     * "pscid":40,"selected":1,"sellerid":19,"subhead":"购买电脑办公部分商品满1元返火车票5元优惠券（返完即止）","title":"全球购 新款Apple MacBook
     * Pro 苹果笔记本电脑 银色VP2新13英寸Bar i5/8G/256G"}],"sellerName":"商家19","sellerid":"19"},{"list":[{"bargainPrice":111.99,
     * "createtime":"2017-10-03T23:53:28","detailUrl":"https://item.m.jd
     * .com/product/4719303.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term
     * =QQfriends","images":"https://m.360buyimg
     * .com/n0/jfs/t9004/210/1160833155/647627/ad6be059/59b4f4e1N9a2b1532.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t7504/338/63721388/491286/f5957f53/598e95f1N7f2adb87.jpg!q70.jpg|https://m.360buyimg
     * .com/n0/jfs/t7441/10/64242474/419246/adb30a7d/598e95fbNd989ba0a.jpg!q70.jpg","num":2,"pid":6,"price":7.99,
     * "pscid":1,"selected":1,"sellerid":22,
     * "subhead":"每个中秋都不能简单，无论身在何处，你总需要一块饼让生活更圆满，京东月饼让爱更圆满京东自营，闪电配送，更多惊喜，快用手指戳一下","title":"北京稻香村 稻香村中秋节月饼
     * 老北京月饼礼盒655g"},{"bargainPrice":11800,"createtime":"2017-10-14T21:38:26","detailUrl":"https://mitem.jd
     * .hk/ware/view.action?wareId=1988853309&cachekey=1acb07a701ece8d2434a6ae7fa6870a1",
     * "images":"https://m.360buyimg.com/n0/jfs/t6130/97/1370670410/180682/1109582a/593276b1Nd81fe723.jpg!q70.jpg
     * |https://m.360buyimg.com/n0/jfs/t5698/110/2617517836/202970/c9388feb/593276b7Nbd94ef1f
     * .jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5698/110/2617517836/202970/c9388feb/593276b7Nbd94ef1f
     * .jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5815/178/2614671118/51656/7f52d137/593276c7N107b725a
     * .jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t5878/60/2557817477/30873/4502b606/593276caN5a7d6357.jpg!q70.jpg",
     * "num":2,"pid":78,"price":999,"pscid":40,"selected":1,"sellerid":22,"subhead":"购买电脑办公部分商品满1元返火车票5元优惠券（返完即止）",
     * "title":"全球购 新款Apple MacBook Pro 苹果笔记本电脑 银色VP2新13英寸Bar i5/8G/256G"}],"sellerName":"商家22","sellerid":"22"}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * list : [{"bargainPrice":6666,"createtime":"2017-10-10T16:01:31","detailUrl":"https://item.m.jd
         * .com/product/5089273.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term
         * =QQfriends","images":"https://m.360buyimg
         * .com/n0/jfs/t8284/363/1326459580/71585/6d3e8013/59b857f2N6ca75622.jpg!q70.jpg|https://m.360buyimg
         * .com/n0/jfs/t9346/182/1406837243/282106/68af5b54/59b8480aNe8af7f5c.jpg!q70.jpg|https://m.360buyimg
         * .com/n0/jfs/t8434/54/1359766007/56140/579509d9/59b85801Nfea207db.jpg!q70.jpg","num":2,"pid":46,
         * "price":234,"pscid":39,"selected":1,"sellerid":2,"subhead":"【iPhone新品上市】新一代iPhone，让智能看起来更不一样",
         * "title":"Apple iPhone 8 Plus (A1864) 64GB 金色 移动联通电信4G手机"},{"bargainPrice":11800,
         * "createtime":"2017-10-14T21:38:26","detailUrl":"https://item.m.jd
         * .com/product/5025518.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term
         * =QQfriends","images":"https://m.360buyimg
         * .com/n0/jfs/t8830/106/1760940277/195595/5cf9412f/59bf2ef5N5ab7dc16.jpg!q70.jpg|https://m.360buyimg
         * .com/n0/jfs/t5428/70/1520969931/274676/b644dd0d/591128e7Nd2f70da0.jpg!q70.jpg|https://m.360buyimg
         * .com/n0/jfs/t5566/365/1519564203/36911/620c750c/591128eaN54ac3363.jpg!q70.jpg","num":7,"pid":58,
         * "price":6399,"pscid":40,"selected":1,"sellerid":2,"subhead":"升级4G大显存！Nvme协议Pcie SSD,
         * 速度快人一步】GTX1050Ti就选拯救者！专业游戏键盘&新模具全新设计！","title":"联想(Lenovo)拯救者R720 15.6英寸游戏笔记本电脑(i5-7300HQ 8G 1T+128G SSD
         * GTX1050Ti 4G IPS 黑)"}]
         * sellerName : 商家2
         * sellerid : 2
         */
        private String sellerName;
        private String sellerid;
        private List<ListBean> list;


        public String getSellerName() {
            return sellerName;
        }

        public void setSellerName(String sellerName) {
            this.sellerName = sellerName;
        }

        public String getSellerid() {
            return sellerid;
        }

        public void setSellerid(String sellerid) {
            this.sellerid = sellerid;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * bargainPrice : 6666.0
             * createtime : 2017-10-10T16:01:31
             * detailUrl : https://item.m.jd.com/product/5089273.html?utm#_source=androidapp&utm#_medium=appshare&utm
             * #_campaign=t#_335139774&utm#_term=QQfriends
             * images : https://m.360buyimg.com/n0/jfs/t8284/363/1326459580/71585/6d3e8013/59b857f2N6ca75622.jpg
             * !q70.jpg|https://m.360buyimg.com/n0/jfs/t9346/182/1406837243/282106/68af5b54/59b8480aNe8af7f5c
             * .jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t8434/54/1359766007/56140/579509d9/59b85801Nfea207db
             * .jpg!q70.jpg
             * num : 2
             * pid : 46
             * price : 234.0
             * pscid : 39
             * selected : 1
             * sellerid : 2
             * subhead : 【iPhone新品上市】新一代iPhone，让智能看起来更不一样
             * title : Apple iPhone 8 Plus (A1864) 64GB 金色 移动联通电信4G手机
             */

            private double bargainPrice;
            private String createtime;
            private String detailUrl;
            private String images;
            private int num;
            private int pid;
            private double price;
            private int pscid;
            private int selected;
            private int sellerid;
            private String subhead;
            private String title;

            public double getBargainPrice() {
                return bargainPrice;
            }

            public void setBargainPrice(double bargainPrice) {
                this.bargainPrice = bargainPrice;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getDetailUrl() {
                return detailUrl;
            }

            public void setDetailUrl(String detailUrl) {
                this.detailUrl = detailUrl;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public int getPid() {
                return pid;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getPscid() {
                return pscid;
            }

            public void setPscid(int pscid) {
                this.pscid = pscid;
            }

            public int getSelected() {
                return selected;
            }

            public void setSelected(int selected) {
                this.selected = selected;
            }

            public int getSellerid() {
                return sellerid;
            }

            public void setSellerid(int sellerid) {
                this.sellerid = sellerid;
            }

            public String getSubhead() {
                return subhead;
            }

            public void setSubhead(String subhead) {
                this.subhead = subhead;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
