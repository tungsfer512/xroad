/*
 * The MIT License
 *
 * Copyright (c) 2019- Nordic Institute for Interoperability Solutions (NIIS)
 * Copyright (c) 2018 Estonian Information System Authority (RIA),
 * Nordic Institute for Interoperability Solutions (NIIS), Population Register Centre (VRK)
 * Copyright (c) 2015-2017 Estonian Information System Authority (RIA), Population Register Centre (VRK)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
import EmptyPlaceholder from './EmptyPlaceholder.vue';

export default {
  title: 'X-Road/EmptyPlaceholder',
  component: EmptyPlaceholder,
  argTypes: {
    data: { control: 'object' },
    noItemsText: { control: 'text' },
    noMatchesText: { control: 'text' },
    loading: { control: 'boolean' },
    filtered: { control: 'boolean' },
    skeletonType: { control: 'text' },
  },
};

const Template = (args, { argTypes }) => ({
  props: Object.keys(argTypes),
  components: { EmptyPlaceholder },
  template: `<div style="background-color: gray; width: 100%; height: 100%; padding: 20px;">
  <empty-placeholder v-bind="$props" /></div>`,
});

export const Primary = Template.bind({});
Primary.args = {
  data: ['asd', 'fsd', 'sdfs'],
  noItemsText: 'no items',
  noMatchesText: 'no matches',
  filtered: false,
  loading: false,
  skeletonType: 'table-heading',
};
