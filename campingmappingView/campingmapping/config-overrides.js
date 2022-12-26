const { override, addWebpackPlugin } = require("customize-cra");
const AntDesignThemePlugin = require("antd-theme-webpack-plugin");
const { getLessVars } = require("antd-theme-generator");
const path = require("path");
const fs = require("fs");
const themeVariables = getLessVars(
  path.join(__dirname, "./src/styles/variables.less")
);
const darkVars = getLessVars("./node_modules/antd/lib/style/themes/dark.less")
const lightVars = getLessVars("./node_modules/antd/lib/style/themes/compact.less")
fs.writeFileSync("./src/themes/dark.json", JSON.stringify(darkVars));
fs.writeFileSync("./src/themes/light.json", JSON.stringify(lightVars));
fs.writeFileSync("./src/themes/theme.json", JSON.stringify(themeVariables));
const options = {
  stylesDir: path.join(__dirname, "./src/styles"),
  antDir: path.join(__dirname, "./node_modules/antd"),
  // 需更換 theme 的變數
  themeVariables: Array.from(
    new Set([
      ...Object.keys(darkVars),
      ...Object.keys(lightVars),
      ...Object.keys(themeVariables),
    ])
  ),
  generateOnce: false
};
module.exports = override(
  // 每次跑 webpack 就會 gen color.less 到 public 下
  addWebpackPlugin(new AntDesignThemePlugin(options))
);