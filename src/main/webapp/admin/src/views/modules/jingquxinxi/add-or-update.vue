<template>
	<div class="addEdit-block" :style='{"minHeight":"100vh","padding":"30px","backgroundAttachment":"fixed","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20220805/c484e59a5aa342b9b57d5aeab159bbbd.png)","display":"flex","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","height":"auto"}' style="width: 100%;">
		<el-form
			:style='{"minHeight":"100vh","padding":"30px","boxShadow":"0 0px 0px rgba(64, 158, 255, .3)","borderRadius":"6px","flexWrap":"wrap","background":"none","display":"block","width":"100%"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="150px"
		>
			<template >
				<el-form-item :style='{"width":"48%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'" label="景点编号" prop="jingdianbianhao">
					<el-input v-model="ruleForm.jingdianbianhao" placeholder="景点编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.jingdianbianhao" label="景点编号" prop="jingdianbianhao">
					<el-input v-model="ruleForm.jingdianbianhao" placeholder="景点编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="景点标题" prop="jingdianbiaoti">
					<el-input v-model="ruleForm.jingdianbiaoti" placeholder="景点标题" clearable  :readonly="ro.jingdianbiaoti"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 20px 0"}' v-else class="input" label="景点标题" prop="jingdianbiaoti">
					<el-input v-model="ruleForm.jingdianbiaoti" placeholder="景点标题" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 20px 0"}' class="upload" v-if="type!='info' && !ro.jingdianzhaopian" label="景点照片" prop="jingdianzhaopian">
					<file-upload
						tip="点击上传景点照片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.jingdianzhaopian?ruleForm.jingdianzhaopian:''"
						@change="jingdianzhaopianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 20px 0"}' class="upload" v-else-if="ruleForm.jingdianzhaopian" label="景点照片" prop="jingdianzhaopian">
					<img v-if="ruleForm.jingdianzhaopian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.jingdianzhaopian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.jingdianzhaopian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="景点位置" prop="jingdianweizhi">
					<el-input v-model="ruleForm.jingdianweizhi" placeholder="景点位置" clearable  :readonly="ro.jingdianweizhi"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 20px 0"}' v-else class="input" label="景点位置" prop="jingdianweizhi">
					<el-input v-model="ruleForm.jingdianweizhi" placeholder="景点位置" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"width":"48%","margin":"0 0 20px 0"}' class="textarea" v-if="type!='info'" label="景点简介" prop="jingdianjianjie">
					<el-input
					  style="min-width: 200px; max-width: 600px;"
					  type="textarea"
					  :rows="8"
					  placeholder="景点简介"
					  v-model="ruleForm.jingdianjianjie" >
					</el-input>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 20px 0"}' v-else-if="ruleForm.jingdianjianjie" label="景点简介" prop="jingdianjianjie">
					<span :style='{"fontSize":"14px","lineHeight":"40px","color":"#000","fontWeight":"500","display":"inline-block"}'>{{ruleForm.jingdianjianjie}}</span>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 20px 0"}' v-if="type!='info'"  label="景点详情" prop="jingdianxiangqing">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.jingdianxiangqing" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"width":"48%","margin":"0 0 20px 0"}' v-else-if="ruleForm.jingdianxiangqing" label="景点详情" prop="jingdianxiangqing">
                    <span :style='{"fontSize":"14px","lineHeight":"40px","color":"#000","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.jingdianxiangqing"></span>
                </el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0"}' class="btn">
				<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"#000","borderRadius":"30px","background":"#D5EBC4","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
				<el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#000","borderRadius":"30px","background":"#D5EBC4","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
				<el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#000","borderRadius":"30px","background":"#D5EBC4","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				jingdianbianhao : false,
				jingdianbiaoti : false,
				jingdianzhaopian : false,
				jingdianweizhi : false,
				jingdianjianjie : false,
				jingdianxiangqing : false,
			},
			
			
			ruleForm: {
				jingdianbianhao: this.getUUID(),
				jingdianbiaoti: '',
				jingdianzhaopian: '',
				jingdianweizhi: '',
				jingdianjianjie: '',
				jingdianxiangqing: '',
			},
		
			
			rules: {
				jingdianbianhao: [
				],
				jingdianbiaoti: [
				],
				jingdianzhaopian: [
				],
				jingdianweizhi: [
				],
				jingdianjianjie: [
				],
				jingdianxiangqing: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='jingdianbianhao'){
							this.ruleForm.jingdianbianhao = obj[o];
							this.ro.jingdianbianhao = true;
							continue;
						}
						if(o=='jingdianbiaoti'){
							this.ruleForm.jingdianbiaoti = obj[o];
							this.ro.jingdianbiaoti = true;
							continue;
						}
						if(o=='jingdianzhaopian'){
							this.ruleForm.jingdianzhaopian = obj[o];
							this.ro.jingdianzhaopian = true;
							continue;
						}
						if(o=='jingdianweizhi'){
							this.ruleForm.jingdianweizhi = obj[o];
							this.ro.jingdianweizhi = true;
							continue;
						}
						if(o=='jingdianjianjie'){
							this.ruleForm.jingdianjianjie = obj[o];
							this.ro.jingdianjianjie = true;
							continue;
						}
						if(o=='jingdianxiangqing'){
							this.ruleForm.jingdianxiangqing = obj[o];
							this.ro.jingdianxiangqing = true;
							continue;
						}
				}
				






			}
			
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
			
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `jingquxinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        this.ruleForm.jingdianxiangqing = this.ruleForm.jingdianxiangqing.replace(reg,'../../../ssmye471/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {






	if(this.ruleForm.jingdianzhaopian!=null) {
		this.ruleForm.jingdianzhaopian = this.ruleForm.jingdianzhaopian.replace(new RegExp(this.$base.url,"g"),"");
	}







var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "jingquxinxi/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `jingquxinxi/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.jingquxinxiCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `jingquxinxi/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.jingquxinxiCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.jingquxinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    jingdianzhaopianUploadChange(fileUrls) {
	    this.ruleForm.jingdianzhaopian = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #666;
	  	  font-weight: 500;
	  	  width: 150px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 150px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 0;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #000;
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-width: 400px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 0;
	  	  padding: 0 10px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #000;
	  	  width: auto;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 0;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #000;
	  	  width: auto;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  	  border: 2px dashed #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 90px;
	  	  font-size: 32px;
	  	  line-height: 90px;
	  	  text-align: center;
	  	  height: 90px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 2px dashed #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 90px;
	  	  font-size: 32px;
	  	  line-height: 90px;
	  	  text-align: center;
	  	  height: 90px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 2px dashed #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 90px;
	  	  font-size: 32px;
	  	  line-height: 90px;
	  	  text-align: center;
	  	  height: 90px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 0;
	  	  padding: 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #000;
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-height: 120px;
	  	  min-width: 400px;
	  	  height: auto;
	  	}
</style>
