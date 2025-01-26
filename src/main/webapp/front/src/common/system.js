export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["新增","查看","修改","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["新增","查看","修改","删除"],"menu":"套餐类别","menuJump":"列表","tableName":"taocanleibie"}],"menu":"套餐类别管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["新增","查看","修改","删除"],"menu":"样式类别","menuJump":"列表","tableName":"yangshileibie"}],"menu":"样式类别管理"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["新增","查看","修改","删除"],"menu":"定制类别","menuJump":"列表","tableName":"dingzhileibie"}],"menu":"定制类别管理"},{"child":[{"appFrontIcon":"cuIcon-goodsnew","buttons":["新增","查看","修改","删除","查看评论"],"menu":"套餐信息","menuJump":"列表","tableName":"taocanxinxi"}],"menu":"套餐信息管理"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["新增","查看","修改","删除","查看评论"],"menu":"服饰信息","menuJump":"列表","tableName":"fushixinxi"}],"menu":"服饰信息管理"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["查看","修改","删除","查看评论","新增"],"menu":"定制专区","menuJump":"列表","tableName":"dingzhizhuanqu"}],"menu":"定制专区管理"},{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","修改","删除","审核"],"menu":"定制订单","menuJump":"列表","tableName":"dingzhidingdan"}],"menu":"定制订单管理"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["新增","查看","修改","删除","查看评论"],"menu":"景区信息","menuJump":"列表","tableName":"jingquxinxi"}],"menu":"景区信息管理"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看","修改"],"menu":"关于我们","tableName":"aboutus"},{"appFrontIcon":"cuIcon-news","buttons":["查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-form","buttons":["查看","修改"],"menu":"系统简介","tableName":"systemintro"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"公告资讯","tableName":"news"},{"appFrontIcon":"cuIcon-service","buttons":["新增","查看","修改","删除"],"menu":"在线客服","tableName":"chat"}],"menu":"系统管理"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["查看","删除","发货"],"menu":"已支付订单","tableName":"orders/已支付"},{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","删除"],"menu":"已完成订单","tableName":"orders/已完成"},{"appFrontIcon":"cuIcon-newshot","buttons":["查看","删除"],"menu":"已取消订单","tableName":"orders/已取消"},{"appFrontIcon":"cuIcon-vipcard","buttons":["查看","删除"],"menu":"已退款订单","tableName":"orders/已退款"},{"appFrontIcon":"cuIcon-goods","buttons":["查看","删除"],"menu":"未支付订单","tableName":"orders/未支付"},{"appFrontIcon":"cuIcon-skin","buttons":["查看","删除"],"menu":"已发货订单","tableName":"orders/已发货"}],"menu":"订单管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["查看","查看评论"],"menu":"套餐信息列表","menuJump":"列表","tableName":"taocanxinxi"}],"menu":"套餐信息模块"},{"child":[{"appFrontIcon":"cuIcon-wenzi","buttons":["查看","查看评论"],"menu":"服饰信息列表","menuJump":"列表","tableName":"fushixinxi"}],"menu":"服饰信息模块"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看","查看评论","定制"],"menu":"定制专区列表","menuJump":"列表","tableName":"dingzhizhuanqu"}],"menu":"定制专区模块"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看","查看评论"],"menu":"景区信息列表","menuJump":"列表","tableName":"jingquxinxi"}],"menu":"景区信息模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["查看","修改","删除","支付"],"menu":"定制订单","menuJump":"列表","tableName":"dingzhidingdan"}],"menu":"定制订单管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["查看","查看评论"],"menu":"套餐信息列表","menuJump":"列表","tableName":"taocanxinxi"}],"menu":"套餐信息模块"},{"child":[{"appFrontIcon":"cuIcon-wenzi","buttons":["查看","查看评论"],"menu":"服饰信息列表","menuJump":"列表","tableName":"fushixinxi"}],"menu":"服饰信息模块"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看","查看评论","定制"],"menu":"定制专区列表","menuJump":"列表","tableName":"dingzhizhuanqu"}],"menu":"定制专区模块"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看","查看评论"],"menu":"景区信息列表","menuJump":"列表","tableName":"jingquxinxi"}],"menu":"景区信息模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
