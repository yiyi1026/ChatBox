const path = require('path');

module.exports = {
  context: __dirname,
  entry: path.resolve(__dirname, 'frontend', 'src', 'index.jsx'),
  output: {
    path: path.resolve(__dirname, 'frontend', 'public', 'javascripts'),
    publicPath: 'frontend/public',
    filename: 'bundle.js'
  },
  resolve: {
    extensions: ['.js', '.jsx', '*']
  },
  module: {
    rules: [
      {
        test: /\.jsx?$/,
        exclude: /(node_modules)/,
        use: {
          loader: 'babel-loader',
          query: {
            presets: ['@babel/env', '@babel/react']
          }
        },
      }
    ]
  },
  devtool: 'source-map'
};