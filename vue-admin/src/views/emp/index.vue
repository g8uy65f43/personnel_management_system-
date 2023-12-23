<template>
  <div class="app-container">

    <!-- 検索フォーム -->
    <el-form :inline="true" :model="searchEmp" class="demo-form-inline">
      <el-form-item label="名前">
        <el-input
          v-model="searchEmp.name"
          placeholder="従業員の名前を入力してください"
        ></el-input>
      </el-form-item>
      <el-form-item label="性別">
        <el-select v-model="searchEmp.gender" placeholder="選択してください">
          <el-option label="男性" value="1"></el-option>
          <el-option label="女性" value="2"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="入社日">
        <el-date-picker
          v-model="entrydate"
          clearable
          value-format="yyyy-MM-dd"
          type="daterange"
          placeholder="日付を選択"
          range-separator="から"
          start-placeholder="開始日"
          end-placeholder="終了日"
          style="width: 400px; margin-left: 20px"
        ></el-date-picker>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">検索</el-button>
        <el-button type="info" @click="clear">クリア</el-button>
      </el-form-item>
    </el-form>

    <!-- ボタン -->
    <el-row>
      <el-button type="danger" size="medium" @click="deleteByIds">- 一括削除</el-button>
      <el-button type="primary" size="medium" @click="dialogVisible = true; emp = { image: ''};" >+ 新規従業員</el-button>
    </el-row>

    <!-- データ追加ダイアログフォーム -->
    <el-dialog ref="form" title="従業員を編集" :visible.sync="dialogVisible" width="30%">
      <el-form ref="form" :model="emp" label-width="80px" size="mini">
        <el-form-item label="ユーザー名">
          <el-input v-model="emp.username"></el-input>
        </el-form-item>
        <el-form-item label="従業員名">
          <el-input v-model="emp.name"></el-input>
        </el-form-item>

        <el-form-item label="性別" >
          <el-select v-model="emp.gender" placeholder="選択してください" style="width:100%" >
            <el-option
              v-for="item in genderList"
              :key="item.value"
              :label="item.name"
              :value="item.id"
            />
          </el-select>
        </el-form-item>

        <el-form-item label="写真">
          <el-upload
            class="avatar-uploader"
            action="/api/upload"
            :headers="token"
            name="image"
            :show-file-list="false"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload"
          >
            <img v-if="emp.image" :src="emp.image" class="avatar" />
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
        </el-form-item>

        <el-form-item label="職位">
          <el-select v-model="emp.job" placeholder="選択してください" value-key="emp.job" style="width:100%">
            <el-option
              v-for="item in jobList"
              :key="item.value"
              :label="item.name"
              :value="item.id"
            />
          </el-select>
        </el-form-item>

        <el-form-item label="入社日">
          <el-date-picker
            v-model="emp.entrydate"
            clearable
            type="date"
            placeholder="日付を選択"
            size="small"
            style="width:100%"
          ></el-date-picker>
        </el-form-item>

        <el-form-item label="所属部門">
          <el-select v-model="emp.deptId" placeholder="選択してください" style="width:100%">
            <el-option
              v-for="item in deptList"
              :key="item.value"
              :label="item.name"
              :value="item.id"
            />
          </el-select>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="add">送信</el-button>
          <el-button @click="dialogVisible = false">キャンセル</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <br>

    <!-- テーブル -->
    <template>
      <el-table :data="tableData" style="width: 100%" border @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55"  align="center"></el-table-column>
        <el-table-column  prop="name"  label="名前"  align="center"></el-table-column>
        <el-table-column prop="image" label="写真" align="center">
          <template slot-scope="{ row }">
            <el-image style="width: auto; height: 40px; border: none; cursor: pointer" :src="row.image"></el-image>
          </template>
        </el-table-column>

        <el-table-column align="center" label="性別">
          <template slot-scope="scope">
            <span style="margin-right: 10px">
            {{scope.row.gender == "1" ? "男性" : "女性"}}</span>
          </template>
        </el-table-column>

        <el-table-column align="center" label="職位">
          <template slot-scope="scope">
            <span style="margin-right: 10px" v-if="scope.row.job == 1">班主任</span>
            <span style="margin-right: 10px" v-if="scope.row.job == 2">講師</span>
            <span style="margin-right: 10px" v-if="scope.row.job == 3">学務主管</span>
            <span style="margin-right: 10px" v-if="scope.row.job == 4">教務主管</span>
          </template>
        </el-table-column>

        <el-table-column align="center" label="入社日">
          <template slot-scope="scope">
            {{ scope.row.entrydate }}
          </template>
        </el-table-column>
        <el-table-column align="center" label="最終操作時間">
          <template slot-scope="scope">
            {{scope.row.updateTime ? scope.row.updateTime.replace('T',' '):''}}
          </template>
        </el-table-column>

        <el-table-column align="center" label="操作">
          <template slot-scope="scope">
            <el-button type="primary" size="small" @click="update(scope.row.id)">編集</el-button>
            <el-button type="danger" size="small" @click="deleteById(scope.row.id)">削除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </template>

    <!-- ページングツールバー -->
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :background="background"
      :current-page="currentPage"
      :page-sizes="[5, 10, 15, 20]"
      :page-size="5"
      layout="total, sizes, prev, pager, next, jumper"
      :total="totalCount">
    </el-pagination>
  </div>
</template>

<script>
import { page, add, update, deleteById, selectById } from "@/api/emp.js";
import { findAll } from "@/api/dept.js";
import { getToken } from '@/utils/auth';

export default {
  data() {
    return {
      background: true,
      // 1ページに表示されるアイテム数
      pageSize: 5,
      // 総レコード数
      totalCount: 100,
      // 現在のページ番号
      currentPage: 1,
      // ダイアログ表示フラグ
      dialogVisible: false,
      // 検索用データ
      searchEmp: {
        name: "",
        gender: "",
      },
      emp: {
        image: "",
      },
      deptList: [],
      genderList: [{id: 1,name: "男性"},{id: 2,name: "女性"}],
      jobList: [
        {
          id: 1,
          name: "班主任",
        },
        {
          id: 2,
          name: "講師",
        },
        {
          id: 3,
          name: "学務主管",
        },
        {
          id: 4,
          name: "教育研究主管",
        }
      ],

      beginTime: "",
      endTime: "",
      entrydate: "",

      // 選択されたIDの配列
      selectedIds: [],
      // チェックボックスで選択されたデータの配列
      multipleSelection: [],
      // テーブルデータ
      tableData: [],
      token: {token: getToken()}
    };
  },

  mounted() {
    this.page(); // ページが読み込まれたら非同期リクエストを送信してデータを取得する
    findAll().then((result) => {
      this.deptList = result.data.data;
    });
  },

  methods: {
    // ページネーションデータをクエリ
    page() {
      page(
        this.searchEmp.name,
        this.searchEmp.gender,
        this.beginTime,
        this.endTime,
        this.currentPage,
        this.pageSize
      ).then((res) => {
        this.totalCount = res.data.data.total;
        this.tableData = res.data.data.rows;
      });
    },

    // チェックボックスが選択されたら実行
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },

    // 検索メソッド
    onSubmit() {
      this.currentPage = 1;
      this.page();
    },

    clear(){
      this.searchEmp = {name: "", gender: ""};
      this.beginTime = "",
        this.endTime = "";
      this.entrydate = "";
      this.page();
    },
    // データの追加
    add() {
      let operator;

      if (this.emp.id) {
        // 更新
        operator = update(this.emp);
      } else {
        operator = add(this.emp);
      }

      operator.then((resp) => {
        if (resp.data.code == "1") {
          this.dialogVisible = false;
          this.page();
          this.$message({ message: "おめでとうございます、保存されました", type: "success" });
          this.emp = { image: "" };
        } else {
          this.$message.error(resp.data.msg);
        }
      });
    },
    update(id) {
      // 1. ウィンドウを開く
      this.dialogVisible = true;
      // 2. リクエストを送信

      selectById(id).then((result) => {
        if (result.data.code == 1) {
          this.emp = result.data.data;
          this.emp;
        }
      });
    },


    // ページネーション
    handleSizeChange(val) {
      // アイテム数を再設定
      this.pageSize = val;
      this.page();
    },

    handleCurrentChange(val) {
      // 現在のページ番号を再設定
      this.currentPage = val;
      this.page();
    },


    // 従業員情報の削除
    deleteById(id){
      this.$confirm("この操作はデータを削除します、続行しますか？", "注意", {
        confirmButtonText: "確認",
        cancelButtonText: "キャンセル",
        type: "warning",
      }).then(() => {
        // 2. AJAXリクエストを送信
        deleteById(id).then((resp) => {
          if (resp.data.code == 1) {
            // 削除成功
            this.$message.success("おめでとうございます、削除されました");
            this.page();
          } else {
            this.$message.error(resp.data.msg);
          }
        });
      }).catch(() => {
        // ユーザーがキャンセルボタンをクリック
        this.$message.info("削除がキャンセルされました");
      });
    },


    // 従業員情報の一括削除
    deleteByIds() {
      // 確認ダイアログを表示
      this.$confirm("この操作はデータを削除します、続行しますか？", "注意", {
        confirmButtonText: "確認",
        cancelButtonText: "キャンセル",
        type: "warning",
      }).then(() => {
        // ユーザーが確認ボタンをクリック
        // 1. IDの配列を作成、this.multipleSelection から取得
        for (let i = 0; i < this.multipleSelection.length; i++) {
          this.selectedIds[i] = this.multipleSelection[i].id;
        }

        // 2. AJAXリクエストを送信
        deleteById(this.selectedIds).then((resp) => {
          if (resp.data.code == "1") {
            // 削除成功
            this.$message.success("おめでとうございます、削除されました");
            this.page();
          } else {
            this.$message.error(resp.data.msg);
          }
        });
      }).catch(() => {
        // ユーザーがキャンセルボタンをクリック
        this.$message.info("削除がキャンセルされました");
      });
    },


    // ファイルアップロード関連
    handleAvatarSuccess(res, file) {
      this.emp.image = res.data;
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === "image/jpeg";
      const isLt2M = file.size / 1024 / 1024 < 2;
      if (!isJPG) {
        this.$message.error("アップロードするアバター画像はJPG形式である必要があります！");
      }
      if (!isLt2M) {
        this.$message.error("アップロードするアバター画像のサイズは2MBを超えてはいけません！");
      }
      return isJPG && isLt2M;
    },
  },
};
</script>

<style>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 100px;
  height: 100px;
  line-height: 100px;
  text-align: center;
}
.avatar {
  width: 100px;
  height: 100px;
  display: block;
}
</style>
