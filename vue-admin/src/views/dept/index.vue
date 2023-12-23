<template>
  <div style="margin-top: 20px; margin: 50px; margin-right: 100px">
    <!-- ボタン -->

    <el-row>
      <el-button
        style="float: right"
        type="primary"
        @click="dialogFormVisible = true; dept={}"
      >+ 部署を追加</el-button
      >
    </el-row>
    <br>
    <!-- データテーブル -->
    <template>
      <el-table
        highlight-current-row
        ref="multipleTable"
        :data="tableData"
        tooltip-effect="dark"
        style="width: 100%"
        border
      >
        <el-table-column type="index" width="100" label="番号" header-align="center" align="center"> </el-table-column>
        <el-table-column prop="name" label="部署名" header-align="center" align="center"></el-table-column>
        <el-table-column label="最終操作時間" header-align="center" align="center">
          <template slot-scope="scope">
            {{scope.row.updateTime ? scope.row.updateTime.replace('T',' '):''}}
          </template>
        </el-table-column>

        <el-table-column label="操作" width="420" header-align="center" align="center">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="primary"
              plain
              @click="selectById(scope.row.id)"
            >編集</el-button
            >

            <el-button
              size="mini"
              type="danger"
              plain
              @click="deleteById(scope.row.id)"
            >削除</el-button
            >
          </template>
        </el-table-column>
      </el-table>
    </template>

    <!-- 新規ダイアログ -->

    <el-dialog title="部署を保存" :visible.sync="dialogFormVisible" >
      <el-form :model="dept">
        <el-form-item label="部署名" :label-width="formLabelWidth">
          <el-input v-model="dept.name"  placeholder="部署名を入力してください" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>

      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">キャンセル</el-button>
        <el-button type="primary" @click="add()">確定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { findAll, add, update, deleteById, selectById } from "@/api/dept.js";

export default {
  data() {
    return {
      formLabelWidth: "120px",
      dialogFormVisible: false, //ダイアログの可視性を制御
      dept: {
        name: "",
      },
      tableData: [],
    };
  },

  methods: {

    //部署を削除
    deleteById(id) {
      this.$confirm("削除してもよろしいですか？", "注意", {
        confirmButtonText: "確定",
        cancelButtonText: "キャンセル",
        type: "warning",
      }).then(() => {
        deleteById(id).then((result) => {
          if(result.data.code == 1){
            this.$message({
              message: "おめでとうございます、削除されました",
              type: "success",
            });
          }else{
            this.$message.error(result.data.msg);
          }
          //データ再検索
          this.init();
        });
      }).catch(() => {
        this.$message({
          type: "info",
          message: "削除がキャンセルされました",
        });
      });
    },

    //IDによる部署の検索 -- 表示
    selectById(id) {
      this.dialogFormVisible = true;
      selectById(id).then((result) => {
        this.dept = result.data.data;
      });
    },

    //保存メソッド
    add() {
      let method ;// 追加
      if (this.dept.id) {
        method = update(this.dept); // 修正
      }else{
        method = add(this.dept); //追加
      }
      method.then((result) => {
        if (result.data.code == 1) {
          //修正成功
          this.$message.success("おめでとうございます、保存されました");
          //データ再検索
          this.init();
        } else {
          this.$message.error(result.data.msg);
        }
      });
      // 新規作成ウィンドウを閉じる
      this.dialogFormVisible = false;

      // モデルデータをクリア
      this.dept = {};
    },

    //初期化 - すべてのデータを検索
    init() {
      findAll().then((result) => {
        console.log(result);
        if (result.data.code == 1) {
          this.tableData = result.data.data;
        }
      });
    },
  },
  mounted() {
    //ページが読み込まれたら自動的に実行。
    this.init();
  },
};
</script>
<style>

</style>
