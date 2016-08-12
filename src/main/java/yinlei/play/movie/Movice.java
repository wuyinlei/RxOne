package yinlei.play.movie;

import java.util.List;

/**
 * Created by Administrator on 2016/8/12.
 */
public class Movice {


    /**
     * error_code : 0
     * reason : Success
     * result : [{"rid":"1","name":"白发魔女传之明月天","actor":"黄晓明 / 范冰冰 / 赵文卓","wk":"(第31周) 07月28日-08月03日","wboxoffice":"￥ 22400","tboxoffice":"￥ 22400"},{"rid":"2","name":"后会无期","actor":"陈柏霖 / 冯绍峰 / 陈乔恩","wk":"(第31周) 07月28日-08月03日","wboxoffice":"￥ 22060","tboxoffice":"￥ 51560"},{"rid":"3","name":"闺蜜","actor":"陈意涵 / 薛凯琪 / 杨子姗","wk":"(第31周) 07月28日-08月03日","wboxoffice":"￥ 10650","tboxoffice":"￥ 10650"},{"rid":"4","name":"京城81号","actor":"吴镇宇 / 林心如 / 杨佑宁","wk":"(第31周) 07月28日-08月03日","wboxoffice":"￥ 6200","tboxoffice":"￥ 39400"},{"rid":"5","name":"暴力街区","actor":"保罗·沃克","wk":"(第31周) 07月28日-08月03日","wboxoffice":"￥ 4800","tboxoffice":"￥ 4800"},{"rid":"6","name":"小时代3：刺金时代","actor":"杨幂 / 郭采洁 / 郭碧婷","wk":"(第31周) 07月28日-08月03日","wboxoffice":"￥ 4200","tboxoffice":"￥ 51550"},{"rid":"7","name":"龙之谷：破晓奇兵","actor":"景甜 / 胡歌 / 夏梓桐 / 徐娇","wk":"(第31周) 07月28日-08月03日","wboxoffice":"￥ 3500","tboxoffice":"￥ 3500"},{"rid":"8","name":"神笔马良","actor":"孟祥龙 / 洪海天 / 吴文伦","wk":"(第31周) 07月28日-08月03日","wboxoffice":"￥ 2350","tboxoffice":"￥ 5330"},{"rid":"9","name":"幻影车神：魔盗激情","actor":"阿米尔·汗","wk":"(第31周) 07月28日-08月03日","wboxoffice":"￥ 1010","tboxoffice":"￥ 1860"},{"rid":"10","name":"不再说分手","actor":"郑伊健 / 王菀之 / 周秀娜","wk":"(第31周) 07月28日-08月03日","wboxoffice":"￥ 660","tboxoffice":"￥ 660"},{"rid":"11","name":"老男孩猛龙过江","actor":"王太利 / 肖央 / 屈菁菁","wk":"(第31周) 07月28日-08月03日","wboxoffice":"￥ 465","tboxoffice":"￥ 21020"},{"rid":"12","name":"分手大师","actor":"邓超 / 杨幂 / 孙俪 / 梁超","wk":"(第31周) 07月28日-08月03日","wboxoffice":"￥ 350","tboxoffice":"￥ 66920"},{"rid":"13","name":"我想结婚的时候你在","actor":"郭品超 / 周秀娜 / 瞿颖","wk":"(第31周) 07月28日-08月03日","wboxoffice":"￥ 250","tboxoffice":"￥ 250"},{"rid":"14","name":"开心超人2：启源星之","actor":"刘红韵 / 祖晴 / 邓玉婷","wk":"(第31周) 07月28日-08月03日","wboxoffice":"￥ 160","tboxoffice":"￥ 2790"},{"rid":"15","name":"我就是我","actor":"华晨宇 / 欧豪 / 白举纲","wk":"(第31周) 07月28日-08月03日","wboxoffice":"￥ 155","tboxoffice":"￥ 595"}]
     */

    private int error_code;
    private String reason;
    /**
     * rid : 1
     * name : 白发魔女传之明月天
     * actor : 黄晓明 / 范冰冰 / 赵文卓
     * wk : (第31周) 07月28日-08月03日
     * wboxoffice : ￥ 22400
     * tboxoffice : ￥ 22400
     */

    private List<ResultBean> result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private String rid;
        private String name;
        private String actor;
        private String wk;
        private String wboxoffice;
        private String tboxoffice;

        public String getRid() {
            return rid;
        }

        public void setRid(String rid) {
            this.rid = rid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getActor() {
            return actor;
        }

        public void setActor(String actor) {
            this.actor = actor;
        }

        public String getWk() {
            return wk;
        }

        public void setWk(String wk) {
            this.wk = wk;
        }

        public String getWboxoffice() {
            return wboxoffice;
        }

        public void setWboxoffice(String wboxoffice) {
            this.wboxoffice = wboxoffice;
        }

        public String getTboxoffice() {
            return tboxoffice;
        }

        public void setTboxoffice(String tboxoffice) {
            this.tboxoffice = tboxoffice;
        }
    }
}
