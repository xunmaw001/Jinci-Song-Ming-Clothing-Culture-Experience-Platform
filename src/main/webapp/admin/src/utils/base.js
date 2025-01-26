const base = {
    get() {
        return {
            url : "http://localhost:8080/ssmye471/",
            name: "ssmye471",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmye471/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "晋祠宋明服饰文化体验平台"
        } 
    }
}
export default base
