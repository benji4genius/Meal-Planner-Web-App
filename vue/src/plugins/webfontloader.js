/* eslint-disable import/no-unresolved */
// src/plugins/webfontloader.js
import WebFont from 'webfontloader';

export function loadFonts() {
  WebFont.load({
    google: {
      families: ['Roboto:100,300,400,500,700,900&amp;display=swap']
    }
  });
}